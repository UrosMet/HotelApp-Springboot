package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.repository.GostRepository;
import com.metropolitan.it355.services.GostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GostServiceImpl implements GostService {
    final GostRepository gostRepository;
}
