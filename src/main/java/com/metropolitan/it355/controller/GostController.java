package com.metropolitan.it355.controller;

import com.metropolitan.it355.repository.GostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class GostController {
    private final GostRepository gostRepository;
}
