package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Soba;
import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.repository.SobaRepository;
import com.metropolitan.it355.repository.SobaSlikaRepository;
import com.metropolitan.it355.services.SobaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SobaServiceImpl implements SobaService {

    final SobaRepository sobaRepository;
    final SobaSlikaRepository sobaSlikaRepository;

    private static final String UPLOAD_DIR = "./src/main/resources/images/";

    /**
     * Metoda vraca sve sobe
     *
     * @return List<Soba>
     */
    @Override
    public List<Soba> getAll() {
        return sobaRepository.findAll();
    }

    /**
     * Metoda vraca jednog sobu po ID
     *
     * @param id
     * @return Soba
     */
    @Override
    public Optional<?> getById(int id) {
        return sobaRepository.findById(id);
    }

    /**
     * Metoda dodaje jednu sobu u bazu
     *
     * @param soba
     * @return Soba
     */
    @Override
    public Soba add(Soba soba) {
        return sobaRepository.save(soba);
    }

    /**
     * Metoda update-uje sobu u bazu
     *
     * @param soba
     * @return Soba
     */
    @Override
    public Soba update(Soba soba) {
        return sobaRepository.save(soba);
    }

    /**
     * Metoda brise sobu iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        sobaRepository.deleteById(id);
    }

    /**
     * Metoda brise sobu i sve slike iz foldera za datu sobu
     *
     * @param id
     */
    @Override
    public void deleteSobaAndImages(int id) {
        Optional<?> opt = getById(id);
        if (opt.isPresent()) {
            Soba soba = (Soba)opt.get();
            List<SobaSlika> list = sobaSlikaRepository.findAllByIdSoba(soba.getId());
            for (SobaSlika sobaSlika : list) {
                Path target = Paths.get(UPLOAD_DIR + sobaSlika.getSlikaUrl());
                try {
                    Files.deleteIfExists(target);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sobaSlikaRepository.delete(sobaSlika);
            }
            delete(id);
        }
    }
}
