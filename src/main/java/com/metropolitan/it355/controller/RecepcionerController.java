package com.metropolitan.it355.controller;

import com.metropolitan.it355.repository.RecepcionerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class RecepcionerController {

    private final RecepcionerRepository recepcionerRepository;

}
