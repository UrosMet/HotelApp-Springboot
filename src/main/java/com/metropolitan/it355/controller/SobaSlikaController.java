package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.services.SobaSlikaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sobaslike")
public class SobaSlikaController {
    final SobaSlikaService sobaSlikaService;

    @GetMapping
    public ResponseEntity<List<SobaSlika>> findAll() {
        return ResponseEntity.ok(sobaSlikaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SobaSlika> findById(@PathVariable int id) {
        return ResponseEntity.ok(sobaSlikaService.getById(id));
    }

    @GetMapping("/soba/{idSoba}")
    public ResponseEntity<List<SobaSlika>> findAllByIdSoba(@PathVariable int idSoba) {
        return ResponseEntity.ok(sobaSlikaService.getAllByIdSoba(idSoba));
    }

    @PostMapping
    public ResponseEntity<SobaSlika> save(@RequestBody SobaSlika sobaSlika) {
        return ResponseEntity.ok(sobaSlikaService.add(sobaSlika));
    }

    @PutMapping
    public ResponseEntity<SobaSlika> update(@RequestBody SobaSlika sobaSlika) {
        return ResponseEntity.ok(sobaSlikaService.update(sobaSlika));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SobaSlika> delete(@PathVariable int id) {
        SobaSlika sobaSlika = sobaSlikaService.getById(id);
        sobaSlikaService.delete(id);
        return ResponseEntity.ok(sobaSlika);
    }
}
