package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.repository.TransportRepository;
import com.metropolitan.it355.services.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransportServiceImpl implements TransportService {

    final TransportRepository transportRepository;

}
