package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Transport;
import com.metropolitan.it355.services.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Transport> findById(@PathVariable int id) {
        return ResponseEntity.ok(transportService.getById(id));
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
    public ResponseEntity<Transport> delete(@PathVariable int id) {
        Transport transport = transportService.getById(id);
        transportService.delete(id);
        return ResponseEntity.ok(transport);
    }


}
