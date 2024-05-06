package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.SobaSlika;

import java.util.List;

public interface SobaSlikaService {

    /**
     * Metoda vraca sve slike sobe
     * @return List<SobaSlika>
     */
    List<SobaSlika> getAll();

    /**
     * Metoda vraca jednog sliku po ID
     * @param id
     * @return SobaSlika
     */
    SobaSlika getById(int id);

    /**
     * Metoda dodaje jednu sliku u bazu
     * @param sobaSlika
     * @return SobaSlika
     */
    SobaSlika add(SobaSlika sobaSlika);

    /**
     * Metoda update-uje sobu u bazu
     * @param sobaSlika
     * @return SobaSlika
     */
    SobaSlika update(SobaSlika sobaSlika);

    /**
     * Metoda brise sliku iz baze po ID
     * @param id
     */
    void delete(int id);

    /**
     * Metoda vraca sve slike za odredjenu sobu po ID
     * @param idSoba
     * @return List<SobaSlika>
     */
    List<SobaSlika> getAllByIdSoba(Integer idSoba);
    
}
