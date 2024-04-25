package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Transport;
import com.metropolitan.it355.repository.TransportRepository;
import com.metropolitan.it355.services.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TransportServiceImpl implements TransportService {

    final TransportRepository transportRepository;


    /**
     * Metoda vraca sve Transporte
     *
     * @return List<Transport>
     */
    @Override
    public List<Transport> getAll() {
        return transportRepository.findAll();
    }

    /**
     * Metoda vraca jednog Transporta po ID
     *
     * @param id
     * @return Transport
     */
    @Override
    public Transport getById(int id) {
        return transportRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No transport found with id: " + id));
    }

    /**
     * Metoda dodaje jednog Transporta u bazu
     *
     * @param transport
     * @return Transport
     */
    @Override
    public Transport add(Transport transport) {
        return transportRepository.save(transport);
    }

    /**
     * Metoda update-uje Transporta u bazu
     *
     * @param transport
     * @return Transport
     */
    @Override
    public Transport update(Transport transport) {
        return transportRepository.save(transport);
    }

    /**
     * Metoda brise Transporta iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        transportRepository.deleteById(id);
    }
}
