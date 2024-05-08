package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Cenovnik;
import com.metropolitan.it355.services.CenovnikService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cenovnik")
public class CenovnikController {

    final CenovnikService cenovnikService;

    @GetMapping
    public ResponseEntity<List<Cenovnik>> findAll() {
        return ResponseEntity.ok(cenovnikService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (cenovnikService.getById(id).isPresent()){
            return ResponseEntity.ok(cenovnikService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

    @PostMapping
    public ResponseEntity<Cenovnik> save(@RequestBody Cenovnik Cenovnik) {
        return ResponseEntity.ok(cenovnikService.add(Cenovnik));
    }

    @PutMapping
    public ResponseEntity<Cenovnik> update(@RequestBody Cenovnik Cenovnik) {
        return ResponseEntity.ok(cenovnikService.update(Cenovnik));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> cenovnik = cenovnikService.getById(id);

        if (cenovnik.isPresent()) {
            cenovnikService.delete(id);
            return ResponseEntity.ok(cenovnik);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

}
