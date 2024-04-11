package com.metropolitan.it355.controller;

import com.metropolitan.it355.repository.SobaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class SobaController {

    private final SobaRepository sobaRepository;

}
