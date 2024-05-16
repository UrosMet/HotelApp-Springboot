package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.repository.RecepcionerRepository;
import com.metropolitan.it355.services.RecepcionerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecepcionerServiceImpl implements RecepcionerService, UserDetailsService {

    final RecepcionerRepository recepcionerRepository;
    private final PasswordEncoder passwordEncoder;
    private final Path rootLocation = Paths.get("./src/main/resources/images");
    private static final String UPLOAD_DIR = "./src/main/resources/images/";
    /**
     * Metoda vraca sve Recepcionere
     *
     * @return List<Recepcioner>
     */
    @Override
    public List<Recepcioner> getAll() {
        return recepcionerRepository.findAll();
    }

    /**
     * Metoda vraca jednog Recepcionera po ID
     *
     * @param id
     * @return Recepcioner
     */
    @Override
    public Optional<?> getById(int id) {
        return recepcionerRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Recepcionera u bazu
     *
     * @param recepcioner
     * @return Recepcioner
     */
    @Override
    public Recepcioner add(Recepcioner recepcioner) {
        return recepcionerRepository.save(recepcioner);
    }

    /**
     * Metoda update-uje Recepcionera u bazu
     *
     * @param recepcioner
     * @return Recepcioner
     */
    @Override
    public Recepcioner update(Recepcioner recepcioner) {
//        recepcioner.setLozinka(passwordEncoder.encode(recepcioner.getLozinka()));
//        return recepcionerRepository.save(recepcioner);

        Optional<Recepcioner> existingReceptionist = recepcionerRepository.findById(recepcioner.getId());
        if (existingReceptionist.isPresent()) {
            Recepcioner updatedReceptionist = existingReceptionist.get();
            updatedReceptionist.setIme(recepcioner.getIme());
            updatedReceptionist.setPrezime(recepcioner.getPrezime());
            updatedReceptionist.setKorisnickoIme(recepcioner.getKorisnickoIme());
            updatedReceptionist.setLozinka(passwordEncoder.encode(recepcioner.getLozinka()));
            updatedReceptionist.setRole(recepcioner.getRole());
            if (recepcioner.getProfilnaSlika() != null) {
                updatedReceptionist.setProfilnaSlika(recepcioner.getProfilnaSlika());
            }

            System.err.println("Updated Receptionist: " + updatedReceptionist);

            return recepcionerRepository.save(updatedReceptionist);
        } else {
            throw new EntityNotFoundException("Receptionist not found with ID: " + recepcioner.getId());
        }
    }

    /**
     * Metoda brise Recepcionera iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        recepcionerRepository.deleteById(id);
    }

    /**
     * Metoda dodaje ili updejtuje sliku
     *
     * @param file
     * @return path
     */
    @Override
    public String storeImage(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String cleanedFilename = originalFilename != null ? originalFilename.replace(" ", "_") : null;

            if (cleanedFilename != null) {
                Path targetLocation = rootLocation.resolve(cleanedFilename);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                return cleanedFilename;
            } else {
                throw new RuntimeException("File name is invalid");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @Override
    public Recepcioner updateRecepcioner(int id, String ime, String prezime, String korisnicko_ime, String lozinka, MultipartFile profilna_slika, String role) {
        Optional<?> optional = getById(id);
        if (optional.isPresent()) {
            Recepcioner recepcioner = (Recepcioner) optional.get();
            String url = recepcioner.getProfilnaSlika();
            if (profilna_slika != null && !profilna_slika.isEmpty()) {
                url = storeImage(profilna_slika);
            }
            recepcioner.setProfilnaSlika(url);
            recepcioner.setIme(ime);
            recepcioner.setPrezime(prezime);
            recepcioner.setKorisnickoIme(korisnicko_ime);
            recepcioner.setLozinka(passwordEncoder.encode(lozinka));
            if (role != null) {
                recepcioner.setRole(role);
            }
            return add(recepcioner);
        }
        return null;
    }

    @Override
    public void deleteRecepcionerAndImage(int id) {
        Optional<?> optional = getById(id);
        if (optional.isPresent()) {
            Recepcioner rec = (Recepcioner) optional.get();
            Path target = Paths.get(UPLOAD_DIR + rec.getProfilnaSlika());
            try {
                Files.deleteIfExists(target);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            delete(id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Recepcioner> recepcioner = recepcionerRepository.findByKorisnickoIme(username);
        if(recepcioner.isPresent()) {
            var recepcionerDetails = recepcioner.get();
            return User.builder()
                    .username(recepcionerDetails.getKorisnickoIme())
                    .password(recepcionerDetails.getLozinka())
                    .roles(getRoes(recepcionerDetails))
                    .build();
        }else
            throw new UsernameNotFoundException(username);
    }



    private String getRoes(Recepcioner recepcionerDetails) {
        if (recepcionerDetails.getRole() == null)
            return "USER";
        return recepcionerDetails.getRole();
    }


}
