package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Cenovnik;

import java.util.List;

public interface CenovnikService {
    /**
     * Metoda vraca sve cenovnike
     * @return List<Cenovnik>
     */
    List<Cenovnik> getAll();

    /**
     * Metoda vraca jednog Cenovnika po ID
     * @param id
     * @return Cenovnik
     */
    Cenovnik getById(int id);

    /**
     * Metoda dodaje jednog Cenovnika u bazu
     * @param cenovnik
     * @return Cenovnik
     */
    Cenovnik add(Cenovnik cenovnik);

    /**
     * Metoda update-uje Cenovnika u bazu
     * @param cenovnik
     * @return Cenovnik
     */
    Cenovnik update(Cenovnik cenovnik);

    /**
     * Metoda brise Cenovnika iz baze po ID
     * @param id
     */
    void delete(int id);
}
