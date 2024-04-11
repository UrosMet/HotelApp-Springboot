package com.metropolitan.it355.controller;

import com.metropolitan.it355.repository.CenovnikRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class CenovnikController {
    private final CenovnikRepository cenovnikRepository;
}
