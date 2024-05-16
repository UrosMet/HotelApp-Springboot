package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.services.SobaSlikaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (sobaSlikaService.getById(id).isPresent()){
            return ResponseEntity.ok(sobaSlikaService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

    @GetMapping("/soba/{idSoba}")
    public ResponseEntity<List<SobaSlika>> findAllByIdSoba(@PathVariable int idSoba) {
        return ResponseEntity.ok(sobaSlikaService.getAllByIdSoba(idSoba));
    }

    @PostMapping
    public ResponseEntity<SobaSlika> save(@RequestBody SobaSlika sobaSlika) {
        return ResponseEntity.ok(sobaSlikaService.add(sobaSlika));
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("images") MultipartFile[] images, @RequestParam("sobaId") int sobaId) {
        try {
            return ResponseEntity.ok(sobaSlikaService.uploadImages(images, sobaId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<SobaSlika> update(@RequestBody SobaSlika sobaSlika) {
        return ResponseEntity.ok(sobaSlikaService.update(sobaSlika));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        sobaSlikaService.deleteSobaSlika(id);
        return ResponseEntity.ok().build();
    }
}
