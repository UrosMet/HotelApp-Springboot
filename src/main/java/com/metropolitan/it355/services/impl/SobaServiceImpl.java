package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Soba;
import com.metropolitan.it355.repository.SobaRepository;
import com.metropolitan.it355.services.SobaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SobaServiceImpl implements SobaService {

    final SobaRepository sobaRepository;


    /**
     * Metoda vraca sve sobe
     *
     * @return List<Soba>
     */
    @Override
    public List<Soba> getAll() {
        return sobaRepository.findAll();
    }

    /**
     * Metoda vraca jednog sobu po ID
     *
     * @param id
     * @return Soba
     */
    @Override
    public Soba getById(int id) {
        return sobaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    /**
     * Metoda dodaje jednu sobu u bazu
     *
     * @param soba
     * @return Soba
     */
    @Override
    public Soba add(Soba soba) {
        return sobaRepository.save(soba);
    }

    /**
     * Metoda update-uje sobu u bazu
     *
     * @param soba
     * @return Soba
     */
    @Override
    public Soba update(Soba soba) {
        return sobaRepository.save(soba);
    }

    /**
     * Metoda brise sobu iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        sobaRepository.deleteById(id);
    }
}
