package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.repository.CenovnikRepository;
import com.metropolitan.it355.services.CenovnikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CenovnikServiceImpl implements CenovnikService {

    final CenovnikRepository cenovnikRepository;

}
