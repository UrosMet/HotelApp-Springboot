package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Gost;
import com.metropolitan.it355.repository.GostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gosti")
@AllArgsConstructor
public class GostController {
    private final GostRepository gostRepository;

    @GetMapping
    public ResponseEntity<List<Gost>> getAllProducts() {
        for (Gost gost : gostRepository.findAll())
            System.out.println(gost.getIme());
        return  ResponseEntity.ok(gostRepository.findAll());
    }



}
