package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.SobaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/soba")
public class SobaController {

    final SobaService sobaService;

}
