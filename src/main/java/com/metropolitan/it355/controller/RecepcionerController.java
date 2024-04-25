package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/recepcioner")
public class RecepcionerController {
    
    final RecepcionerService recepcionerService;

    @GetMapping
    public ResponseEntity<List<Recepcioner>> findAll() {
        return ResponseEntity.ok(recepcionerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recepcioner> findById(@PathVariable int id) {
        return ResponseEntity.ok(recepcionerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Recepcioner> save(@RequestBody Recepcioner recepcioner) {
        return ResponseEntity.ok(recepcionerService.add(recepcioner));
    }

    @PutMapping
    public ResponseEntity<Recepcioner> update(@RequestBody Recepcioner recepcioner) {
        return ResponseEntity.ok(recepcionerService.update(recepcioner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recepcioner> delete(@PathVariable int id) {
        Recepcioner recepcioner = recepcionerService.getById(id);
        recepcionerService.delete(id);
        return ResponseEntity.ok(recepcioner);
    }

}
