package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Cenovnik;
import com.metropolitan.it355.services.CenovnikService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Cenovnik> findById(@PathVariable int id) {
        return ResponseEntity.ok(cenovnikService.getById(id));
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
    public ResponseEntity<Cenovnik> delete(@PathVariable int id) {
        Cenovnik cenovnik = cenovnikService.getById(id);
        cenovnikService.delete(id);
        return ResponseEntity.ok(cenovnik);
    }

}
