package com.metropolitan.it355.controller;

import com.metropolitan.it355.repository.TransportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class TransportController {

    private final TransportRepository transportRepository;


}
