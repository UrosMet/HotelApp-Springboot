package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Gost;
import com.metropolitan.it355.services.GostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/gost")
public class GostController {

    final GostService gostService;

    @GetMapping
    public ResponseEntity<List<Gost>> findAll() {
        return ResponseEntity.ok(gostService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (gostService.getById(id).isPresent()){
            return ResponseEntity.ok(gostService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

    @PostMapping
    public ResponseEntity<Gost> save(@RequestBody Gost gost) {
        return ResponseEntity.ok(gostService.add(gost));
    }

    @PutMapping
    public ResponseEntity<Gost> update(@RequestBody Gost gost) {
        return ResponseEntity.ok(gostService.update(gost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> gost = gostService.getById(id);

        if (gost.isPresent()) {
            gostService.delete(id);
            return ResponseEntity.ok(gost);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }




}
