package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.repository.SobaRepository;
import com.metropolitan.it355.services.SobaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SobaServiceImpl implements SobaService {

    final SobaRepository sobaRepository;
}
