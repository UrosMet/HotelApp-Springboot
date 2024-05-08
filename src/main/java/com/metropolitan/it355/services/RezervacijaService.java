package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Rezervacija;

import java.util.List;
import java.util.Optional;

public interface RezervacijaService {
    /**
     * Metoda vraca sve rezervacije
     * @return List<Rezervacija>
     */
    List<Rezervacija> getAll();

    /**
     * Metoda vraca jednu rezervaciju po ID
     * @param id
     * @return Rezervacija
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednu rezervaciju u bazu
     * @param rezervacija
     * @return Rezervacija
     */
    Rezervacija add(Rezervacija rezervacija);

    /**
     * Metoda update-uje rezervaciju u bazu
     * @param rezervacija
     * @return Rezervacija
     */
    Rezervacija update(Rezervacija rezervacija);

    /**
     * Metoda brise rezervaciju iz baze po ID
     * @param id
     */
    void delete(int id);

    /**
     * Vraca sve rezervacije po ID sobe
     * @param idSoba
     * @return List<Rezervacija>
     */
    List<Rezervacija> searchByIdSoba(Integer idSoba);

    /**
     * Vraca sve rezervacije po ID gost
     * @param idGost
     * @return List<Rezervacija>
     */
    List<Rezervacija> searchByIdGost(Integer idGost);

    /**
     * Vraca sve rezervacije po ID recepcioner
     * @param idRecepcioner
     * @return List<Rezervacija>
     */
    List<Rezervacija> searchByIdRecepcioner(Integer idRecepcioner);
}
