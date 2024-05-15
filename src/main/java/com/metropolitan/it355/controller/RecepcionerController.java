package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/recepcioner")
public class RecepcionerController {

    private static final String UPLOAD_DIR = "./src/main/resources/images/";

    final RecepcionerService recepcionerService;
    final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Recepcioner>> findAll() {
        return ResponseEntity.ok(recepcionerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (recepcionerService.getById(id).isPresent()) {
            return ResponseEntity.ok(recepcionerService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }


    @PostMapping
    public ResponseEntity<Recepcioner> save(@RequestBody Recepcioner recepcioner) {
        recepcioner.setLozinka(passwordEncoder.encode(recepcioner.getLozinka()));
        return ResponseEntity.ok(recepcionerService.add(recepcioner));
    }

//    @PutMapping
//    public ResponseEntity<?> update(@RequestParam("ime") String ime,
//                                    @RequestParam("id") Integer id,
//                                    @RequestParam("prezime") String prezime,
//                                    @RequestParam("korisnicko_ime") String korisnicko_ime,
//                                    @RequestParam("lozinka") String lozinka,
//                                    @RequestParam("profilna_slika") MultipartFile profilna_slika) {
//        Optional<?> optional = recepcionerService.getById(id);
//        if (optional.isPresent()) {
//            Recepcioner recepcioner = (Recepcioner) optional.get();
//            String url = null;
//            if (profilna_slika != null && !profilna_slika.isEmpty()) {
//                url = recepcionerService.storeImage(profilna_slika);
//            }
//            recepcioner.setProfilnaSlika(url);
//            recepcioner.setIme(ime);
//            recepcioner.setPrezime(prezime);
//            recepcioner.setKorisnickoIme(korisnicko_ime);
//            recepcioner.setLozinka(passwordEncoder.encode(lozinka));
//            return ResponseEntity.ok(recepcionerService.add(recepcioner));
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
//
//    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam("ime") String ime,
                                    @RequestParam("id") Integer id,
                                    @RequestParam("prezime") String prezime,
                                    @RequestParam("korisnicko_ime") String korisnicko_ime,
                                    @RequestParam("lozinka") String lozinka,
                                    @RequestParam(value = "profilna_slika", required = false) MultipartFile profilna_slika,
                                    @RequestParam(value = "role", required = false) String role) {
        Optional<?> optional = recepcionerService.getById(id);
        if (optional.isPresent()) {
            Recepcioner recepcioner = (Recepcioner) optional.get();
            String url = recepcioner.getProfilnaSlika();
            if (profilna_slika != null && !profilna_slika.isEmpty()) {
                url = recepcionerService.storeImage(profilna_slika);
            }
            recepcioner.setProfilnaSlika(url);
            recepcioner.setIme(ime);
            recepcioner.setPrezime(prezime);
            recepcioner.setKorisnickoIme(korisnicko_ime);
            recepcioner.setLozinka(passwordEncoder.encode(lozinka));
            if (role != null) {
                recepcioner.setRole(role);
            }
            return ResponseEntity.ok(recepcionerService.add(recepcioner));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> recepcioner = recepcionerService.getById(id);
        if (recepcioner.isPresent()) {
            Recepcioner rec = (Recepcioner) recepcioner.get();
            Path target = Paths.get(UPLOAD_DIR + rec.getProfilnaSlika());
            try {
                Files.deleteIfExists(target);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
            }
            recepcionerService.delete(id);
            return ResponseEntity.ok(recepcioner);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }


}
