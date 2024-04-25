package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Rezervacija;
import com.metropolitan.it355.services.RezervacijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Rezervacija> findById(@PathVariable int id) {
        return ResponseEntity.ok(rezervacijaService.getById(id));
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
    public ResponseEntity<Rezervacija> delete(@PathVariable int id) {
        Rezervacija rezervacija = rezervacijaService.getById(id);
        rezervacijaService.delete(id);
        return ResponseEntity.ok(rezervacija);
    }

}
