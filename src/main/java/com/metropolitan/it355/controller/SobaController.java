package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Soba;
import com.metropolitan.it355.repository.SobaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/soba")
public class SobaController {

    private final SobaRepository sobaRepository;

    @GetMapping
    public ResponseEntity<List<Soba>> getAllProducts() {
        System.out.println(sobaRepository.findAll());
        return ResponseEntity.ok(sobaRepository.findAll());
    }

    @GetMapping("/{sobaId}")
    public ResponseEntity<Soba> getById(@PathVariable Integer sobaId)
    {
        return ResponseEntity.ok(sobaRepository.findById(sobaId)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "SobaNotFound")));
    }


}
