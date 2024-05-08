package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Recepcioner;
import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (recepcionerService.getById(id).isPresent()){
            return ResponseEntity.ok(recepcionerService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
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
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> recepcioner = recepcionerService.getById(id);

        if (recepcioner.isPresent()) {
            recepcionerService.delete(id);
            return ResponseEntity.ok(recepcioner);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

}
