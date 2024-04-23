package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.GostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/gost")
public class GostController {

    final GostService gostService;


}
