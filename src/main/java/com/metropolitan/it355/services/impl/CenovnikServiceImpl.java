package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Cenovnik;
import com.metropolitan.it355.repository.CenovnikRepository;
import com.metropolitan.it355.services.CenovnikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CenovnikServiceImpl implements CenovnikService {

    final CenovnikRepository cenovnikRepository;


    /**
     * Metoda vraca sve cenovnike
     *
     * @return List<Cenovnik>
     */
    @Override
    public List<Cenovnik> getAll() {
        return cenovnikRepository.findAll();
    }

    /**
     * Metoda vraca jednog Cenovnika po ID
     *
     * @param id
     * @return Cenovnik
     */
    @Override
    public Cenovnik getById(int id) {
        return cenovnikRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    /**
     * Metoda dodaje jednog Cenovnika u bazu
     *
     * @param cenovnik
     * @return Cenovnik
     */
    @Override
    public Cenovnik add(Cenovnik cenovnik) {
        return cenovnikRepository.save(cenovnik);
    }

    /**
     * Metoda update-uje Cenovnika u bazu
     *
     * @param cenovnik
     * @return Cenovnik
     */
    @Override
    public Cenovnik update(Cenovnik cenovnik) {
        return cenovnikRepository.save(cenovnik);
    }

    /**
     * Metoda brise Cenovnika iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        cenovnikRepository.deleteById(id);
    }
}
