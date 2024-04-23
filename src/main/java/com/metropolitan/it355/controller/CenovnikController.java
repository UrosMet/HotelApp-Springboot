package com.metropolitan.it355.controller;

import com.metropolitan.it355.services.CenovnikService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/cenovnik")
public class CenovnikController {

    final CenovnikService cenovnikService;

}
