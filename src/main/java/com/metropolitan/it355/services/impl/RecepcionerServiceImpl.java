package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.repository.RecepcionerRepository;
import com.metropolitan.it355.services.RecepcionerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecepcionerServiceImpl implements RecepcionerService {
    final RecepcionerRepository recepcionerRepository;
}
