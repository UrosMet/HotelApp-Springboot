package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Gost;
import com.metropolitan.it355.repository.GostRepository;
import com.metropolitan.it355.services.GostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GostServiceImpl implements GostService {

    final GostRepository gostRepository;


    /**
     * Metoda vraca sve Goste
     *
     * @return List<Gost>
     */
    @Override
    public List<Gost> getAll() {
        return  gostRepository.findAll();
    }

    /**
     * Metoda vraca jednog gosta po ID
     *
     * @param id
     * @return Gost
     */
    @Override
    public Optional<?> getById(int id) {
        return gostRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog gosta u bazu
     *
     * @param gost
     * @return Gost
     */
    @Override
    public Gost add(Gost gost) {
        return gostRepository.save(gost);
    }

    /**
     * Metoda update-uje gosta u bazu
     *
     * @param gost
     * @return Gost
     */
    @Override
    public Gost update(Gost gost) {
        return gostRepository.save(gost);
    }

    /**
     * Metoda brise gosta iz baze
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        gostRepository.deleteById(id);
    }
}
