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
                                    @RequestParam(value = "profilna_slika", required = false) MultipartFile profilna_slika,
                                    @RequestParam(value = "role", required = false) String role) {
        return ResponseEntity.ok(recepcionerService.updateRecepcioner(id, ime, prezime, korisnicko_ime, lozinka, profilna_slika, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        recepcionerService.deleteRecepcionerAndImage(id);
        return ResponseEntity.ok().build();
    }


}
