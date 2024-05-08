package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Transport;

import java.util.List;
import java.util.Optional;

public interface TransportService {
    /**
     * Metoda vraca sve Transporte
     * @return List<Transport>
     */
    List<Transport> getAll();

    /**
     * Metoda vraca jednog Transporta po ID
     * @param id
     * @return Transport
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Transporta u bazu
     * @param transport
     * @return Transport
     */
    Transport add(Transport transport);

    /**
     * Metoda update-uje Transporta u bazu
     * @param transport
     * @return Transport
     */
    Transport update(Transport transport);

    /**
     * Metoda brise Transporta iz baze po ID
     * @param id
     */
    void delete(int id);
}
