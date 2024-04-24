package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Soba;
import com.metropolitan.it355.services.SobaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/soba")
public class SobaController {

    final SobaService sobaService;

    @GetMapping
    public ResponseEntity<List<Soba>> findAll() {
        return ResponseEntity.ok(sobaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soba> findById(@PathVariable int id) {
        return ResponseEntity.ok(sobaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Soba> save(@RequestBody Soba Soba) {
        return ResponseEntity.ok(sobaService.add(Soba));
    }

    @PutMapping
    public ResponseEntity<Soba> update(@RequestBody Soba Soba) {
        return ResponseEntity.ok(sobaService.update(Soba));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Soba> delete(@PathVariable int id) {
        Soba soba = sobaService.getById(id);
        sobaService.delete(id);
        return ResponseEntity.ok(soba);
    }

}
