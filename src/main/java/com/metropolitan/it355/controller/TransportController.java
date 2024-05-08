package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Transport;
import com.metropolitan.it355.services.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/transport")
public class TransportController {

    final TransportService transportService;

    @GetMapping
    public ResponseEntity<List<Transport>> findAll() {
        return ResponseEntity.ok(transportService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (transportService.getById(id).isPresent()){
            return ResponseEntity.ok(transportService.getById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }

    @PostMapping
    public ResponseEntity<Transport> save(@RequestBody Transport transport) {
        return ResponseEntity.ok(transportService.add(transport));
    }

    @PutMapping
    public ResponseEntity<Transport> update(@RequestBody Transport transport) {
        return ResponseEntity.ok(transportService.update(transport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<?> transport = transportService.getById(id);
        if (transport.isPresent()) {
            transportService.delete(id);
            return ResponseEntity.ok(transport);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found"));
    }


}
