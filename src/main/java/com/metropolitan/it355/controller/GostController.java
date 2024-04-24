package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Gost;
import com.metropolitan.it355.services.GostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Gost> findById(@PathVariable int id) {
        return ResponseEntity.ok(gostService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Gost> save(@RequestBody Gost gost) {
        System.out.println("AAAAAAA");
        return ResponseEntity.ok(gostService.add(gost));
    }

    @PutMapping
    public ResponseEntity<Gost> update(@RequestBody Gost gost) {
        return ResponseEntity.ok(gostService.update(gost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Gost> delete(@PathVariable int id) {
        Gost gost = gostService.getById(id);
        gostService.delete(id);
        return ResponseEntity.ok(gost);
    }




}
