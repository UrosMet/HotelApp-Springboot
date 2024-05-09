package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/recepcioner")
public class RecepcionerController {

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

//    @PostMapping
//    public ResponseEntity<Recepcioner> save(@RequestParam("ime") String ime,
//                                            @RequestParam("prezime") String prezime,
//                                            @RequestParam("korisnicko_ime") String korisnicko_ime,
//                                            @RequestParam("lozinka") String lozinka,
//                                            @RequestParam("profilna_slika") MultipartFile profilna_slika) {
//        Recepcioner recepcioner = new Recepcioner();
//        String url = null;
//        if (profilna_slika != null && !profilna_slika.isEmpty()) {
//            url = recepcionerService.storeImage(profilna_slika);
//        }
//        recepcioner.setProfilnaSlika(url);
//        recepcioner.setIme(ime);
//        recepcioner.setPrezime(prezime);
//        recepcioner.setKorisnickoIme(korisnicko_ime);
//        recepcioner.setLozinka(passwordEncoder.encode(lozinka));
//        return ResponseEntity.ok(recepcionerService.add(recepcioner));
//    }

    @PostMapping
    public ResponseEntity<Recepcioner> save(@RequestBody Recepcioner recepcioner) {
        recepcioner.setLozinka(passwordEncoder.encode(recepcioner.getLozinka()));
        return ResponseEntity.ok(recepcionerService.add(recepcioner));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam("ime") String ime,
                                    @RequestParam("id") Integer id,
                                    @RequestParam("prezime") String prezime,
                                    @RequestParam("korisnicko_ime") String korisnicko_ime,
                                    @RequestParam("lozinka") String lozinka,
                                    @RequestParam("profilna_slika") MultipartFile profilna_slika) {
        Optional<?> optional = recepcionerService.getById(id);
        if (optional.isPresent()) {
            Recepcioner recepcioner = (Recepcioner) optional.get();
            String url = null;
            if (profilna_slika != null && !profilna_slika.isEmpty()) {
                url = recepcionerService.storeImage(profilna_slika);
            }
            recepcioner.setProfilnaSlika(url);
            recepcioner.setIme(ime);
            recepcioner.setPrezime(prezime);
            recepcioner.setKorisnickoIme(korisnicko_ime);
            recepcioner.setLozinka(passwordEncoder.encode(lozinka));
            return ResponseEntity.ok(recepcionerService.add(recepcioner));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> recepcioner = recepcionerService.getById(id);

        if (recepcioner.isPresent()) {
            recepcionerService.delete(id);
            return ResponseEntity.ok(recepcioner);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }


}
