package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.RezervacijaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {

    final RezervacijaService rezervacijaService;

}
