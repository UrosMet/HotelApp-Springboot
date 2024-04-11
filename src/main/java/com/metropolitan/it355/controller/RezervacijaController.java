package com.metropolitan.it355.controller;

import com.metropolitan.it355.repository.RezervacijaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class RezervacijaController {

    private final RezervacijaRepository rezervacijaRepository;

}
