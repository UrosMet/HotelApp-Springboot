package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Gost;

import java.util.List;
import java.util.Optional;

public interface GostService {

    /**
     * Metoda vraca sve Goste
     * @return List<Gost>
     */
    List<Gost> getAll();

    /**
     * Metoda vraca jednog gosta po ID
     * @param id
     * @return Gost
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog gosta u bazu
     * @param gost
     * @return Gost
     */
    Gost add(Gost gost);

    /**
     * Metoda update-uje gosta u bazu
     * @param gost
     * @return Gost
     */
    Gost update(Gost gost);

    /**
     * Metoda brise gosta iz baze po ID
     * @param id
     */
    void delete(int id);

}
