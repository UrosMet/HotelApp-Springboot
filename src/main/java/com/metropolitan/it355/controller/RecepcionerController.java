package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/recepcioner")
public class RecepcionerController {

    final RecepcionerService recepcionerService;

}
