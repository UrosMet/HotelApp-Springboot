package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Recepcioner;

import java.util.List;

public interface RecepcionerService {

    /**
     * Metoda vraca sve Recepcionere
     * @return List<Recepcioner>
     */
    List<Recepcioner> getAll();

    /**
     * Metoda vraca jednog Recepcionera po ID
     * @param id
     * @return Recepcioner
     */
    Recepcioner getById(int id);

    /**
     * Metoda dodaje jednog Recepcionera u bazu
     * @param recepcioner
     * @return Recepcioner
     */
    Recepcioner add(Recepcioner recepcioner);

    /**
     * Metoda update-uje Recepcionera u bazu
     * @param recepcioner
     * @return Recepcioner
     */
    Recepcioner update(Recepcioner recepcioner);

    /**
     * Metoda brise Recepcionera iz baze po ID
     * @param id
     */
    void delete(int id);


}
