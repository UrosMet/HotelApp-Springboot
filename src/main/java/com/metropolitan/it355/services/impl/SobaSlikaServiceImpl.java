package com.metropolitan.it355.services.impl;


import com.metropolitan.it355.entity.Soba;
import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.repository.SobaSlikaRepository;
import com.metropolitan.it355.services.SobaService;
import com.metropolitan.it355.services.SobaSlikaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.*;

@AllArgsConstructor
@Service
public class SobaSlikaServiceImpl implements SobaSlikaService {

    final SobaSlikaRepository sobaSlikaRepository;
    final SobaService sobaService;

    private static final String UPLOAD_DIR = "./src/main/resources/images/";

    /**
     * Metoda vraca sve slike sobe
     *
     * @return List<SobaSlika>
     */
    @Override
    public List<SobaSlika> getAll() {
        return sobaSlikaRepository.findAll();
    }

    /**
     * Metoda vraca jednog sliku po ID
     *
     * @param id
     * @return SobaSlika
     */
    @Override
    public Optional<?> getById(int id) {
        return sobaSlikaRepository.findById(id);
    }

    /**
     * Metoda dodaje jednu sliku u bazu
     *
     * @param sobaSlika
     * @return SobaSlika
     */
    @Override
    public SobaSlika add(SobaSlika sobaSlika) {
        return sobaSlikaRepository.save(sobaSlika);
    }

    /**
     * Metoda update-uje sobu u bazu
     *
     * @param sobaSlika
     * @return SobaSlika
     */
    @Override
    public SobaSlika update(SobaSlika sobaSlika) {
        return sobaSlikaRepository.save(sobaSlika);
    }

    /**
     * Metoda brise sliku iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        sobaSlikaRepository.deleteById(id);
    }

    /**
     * Metoda vraca sve slike za odredjenu sobu po ID
     *
     * @param idSoba
     * @return List<SobaSlika>
     */
    @Override
    public List<SobaSlika> getAllByIdSoba(Integer idSoba) {
        return sobaSlikaRepository.findAllByIdSoba(idSoba);
    }

    /**
     * Metoda cuva vise slika za jedan smestaj
     *
     * @param sobaSlikaId
     * @param imageUrl
     */
    @Override
    @Transactional
    public void savePhotos(int sobaSlikaId, String imageUrl) {
        Soba soba = (Soba) sobaService.getById(sobaSlikaId)
                .orElseThrow(() -> new RuntimeException("Soba ne postoji sa ovim  id: " + sobaSlikaId));

        SobaSlika photo = new SobaSlika();
        photo.setIdSoba(soba);
        photo.setSlikaUrl(imageUrl);
        sobaSlikaRepository.save(photo);
    }

    /**
     * Metoda uploaduje slike
     *
     * @param images
     * @param sobaId
     * @return Map<String, String>
     */
    @Override
    public Map<String, String> uploadImages(MultipartFile[] images, int sobaId) {
        if (images.length == 0) {
            throw new IllegalArgumentException("Nema fajlova");
        }

        Map<String, String> response = new HashMap<>();
        for (MultipartFile file : images) {
            String originalFilename = Objects.requireNonNull(file.getOriginalFilename());
            String filename = originalFilename.replace(" ", "_");
            String extension = filename.lastIndexOf(".") > 0 ? filename.substring(filename.lastIndexOf(".")) : "";
            String baseFilename = filename.substring(0, filename.lastIndexOf("."));
            String uniqueFilename = baseFilename + "_" + Instant.now().getEpochSecond() + extension;
            Path targetLocation = Paths.get(UPLOAD_DIR + uniqueFilename);
            try {
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            savePhotos(sobaId, uniqueFilename);
            response.put(originalFilename, uniqueFilename);
        }
        return response;
    }

    /**
     * Metoda brise sliku iz foldera po id
     *
     * @param id
     */
    @Override
    public void deleteSobaSlika(int id) {
        Optional<?> sobaSlika = getById(id);
        if (sobaSlika.isPresent()) {
            SobaSlika ss = (SobaSlika) sobaSlika.get();
            Path target = Paths.get(UPLOAD_DIR + ss.getSlikaUrl());
            delete(id);
            try {
                Files.deleteIfExists(target);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
