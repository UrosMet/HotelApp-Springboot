package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.services.SobaSlikaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/sobaslike")
public class SobaSlikaController {

    private static final String UPLOAD_DIR = "./src/main/resources/images/";
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
        if (images.length == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Nema fajlova"));
        }

        Map<String, String> response = new HashMap<>();
        try {
            for (MultipartFile file : images) {
                String originalFilename = Objects.requireNonNull(file.getOriginalFilename());
                String filename = originalFilename.replace(" ", "_");
                String extension = filename.lastIndexOf(".") > 0 ? filename.substring(filename.lastIndexOf(".")) : "";
                String baseFilename = filename.substring(0, filename.lastIndexOf("."));
                String uniqueFilename = baseFilename + "_" + Instant.now().getEpochSecond() + extension;
                Path targetLocation = Paths.get(UPLOAD_DIR + uniqueFilename);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                sobaSlikaService.savePhotos(sobaId, uniqueFilename);
                response.put(originalFilename, uniqueFilename);
            }
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<SobaSlika> update(@RequestBody SobaSlika sobaSlika) {
        return ResponseEntity.ok(sobaSlikaService.update(sobaSlika));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> sobaSlika = sobaSlikaService.getById(id);

        if (sobaSlika.isPresent()) {
            sobaSlikaService.delete(id);
            return ResponseEntity.ok(sobaSlika);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }
}
