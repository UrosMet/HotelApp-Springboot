package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/transport")
public class TransportController {

    final TransportService transportService;


}
