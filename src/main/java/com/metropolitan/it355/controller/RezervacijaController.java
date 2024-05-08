package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Rezervacija;
import com.metropolitan.it355.services.RezervacijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {

    final RezervacijaService rezervacijaService;

    @GetMapping
    public ResponseEntity<List<Rezervacija>> findAll() {
        return ResponseEntity.ok(rezervacijaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (rezervacijaService.getById(id).isPresent()){
            return ResponseEntity.ok(rezervacijaService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

    @GetMapping("/gost/{id}")
    public ResponseEntity<List<Rezervacija>> findByGostId(@PathVariable int id) {
        return ResponseEntity.ok(rezervacijaService.searchByIdGost(id));
    }

    @GetMapping("/recepcioner/{id}")
    public ResponseEntity<List<Rezervacija>> findByRecepcionId(@PathVariable int id) {
        return ResponseEntity.ok(rezervacijaService.searchByIdRecepcioner(id));
    }

    @GetMapping("/soba/{id}")
    public ResponseEntity<List<Rezervacija>> findBySobaId(@PathVariable int id) {
        return ResponseEntity.ok(rezervacijaService.searchByIdSoba(id));
    }

    @PostMapping
    public ResponseEntity<Rezervacija> save(@RequestBody Rezervacija rezervacija) {
        return ResponseEntity.ok(rezervacijaService.add(rezervacija));
    }

    @PutMapping
    public ResponseEntity<Rezervacija> update(@RequestBody Rezervacija rezervacija) {
        return ResponseEntity.ok(rezervacijaService.update(rezervacija));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> rezervacija = rezervacijaService.getById(id);

        if (rezervacija.isPresent()) {
            rezervacijaService.delete(id);
            return ResponseEntity.ok(rezervacija);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

}
