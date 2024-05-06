package com.metropolitan.it355.services.impl;


import com.metropolitan.it355.entity.SobaSlika;
import com.metropolitan.it355.repository.SobaSlikaRepository;
import com.metropolitan.it355.services.SobaSlikaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class SobaSlikaServiceImpl implements SobaSlikaService {

    final SobaSlikaRepository sobaSlikaRepository;

    /**
     * Metoda vraca sve slike sobe
     *
     * @return List<SobaSlika>
     */
    @Override
    public List<SobaSlika> getAll() {
        return sobaSlikaRepository.findAll();
    }

    /**
     * Metoda vraca jednog sliku po ID
     *
     * @param id
     * @return SobaSlika
     */
    @Override
    public SobaSlika getById(int id) {
        return sobaSlikaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    /**
     * Metoda dodaje jednu sliku u bazu
     *
     * @param sobaSlika
     * @return SobaSlika
     */
    @Override
    public SobaSlika add(SobaSlika sobaSlika) {
        return sobaSlikaRepository.save(sobaSlika);
    }

    /**
     * Metoda update-uje sobu u bazu
     *
     * @param sobaSlika
     * @return SobaSlika
     */
    @Override
    public SobaSlika update(SobaSlika sobaSlika) {
        return sobaSlikaRepository.save(sobaSlika);
    }

    /**
     * Metoda brise sliku iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        sobaSlikaRepository.deleteById(id);
    }

    /**
     * Metoda vraca sve slike za odredjenu sobu po ID
     *
     * @param idSoba
     * @return List<SobaSlika>
     */
    @Override
    public List<SobaSlika> getAllByIdSoba(Integer idSoba) {
        return sobaSlikaRepository.findAllByIdSoba(idSoba);
    }


}
