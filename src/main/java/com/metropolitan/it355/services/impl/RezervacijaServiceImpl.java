package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Rezervacija;
import com.metropolitan.it355.repository.RezervacijaRepository;
import com.metropolitan.it355.services.RezervacijaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RezervacijaServiceImpl implements RezervacijaService {

    final RezervacijaRepository rezervacijaRepository;


    /**
     * Metoda vraca sve rezervacije
     *
     * @return List<Rezervacija>
     */
    @Override
    public List<Rezervacija> getAll() {
        return rezervacijaRepository.findAll();
    }

    /**
     * Metoda vraca jednu rezervaciju po ID
     *
     * @param id
     * @return Rezervacija
     */
    @Override
    public Rezervacija getById(int id) {
        return rezervacijaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Rezervacija ne postoji"));
    }

    /**
     * Metoda dodaje jednu rezervaciju u bazu
     *
     * @param rezervacija
     * @return Rezervacija
     */
    @Override
    public Rezervacija add(Rezervacija rezervacija) {
        return rezervacijaRepository.save(rezervacija);
    }

    /**
     * Metoda update-uje rezervaciju u bazu
     *
     * @param rezervacija
     * @return Rezervacija
     */
    @Override
    public Rezervacija update(Rezervacija rezervacija) {
        return rezervacijaRepository.save(rezervacija);
    }

    /**
     * Metoda brise rezervaciju iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        rezervacijaRepository.deleteById(id);
    }

    /**
     * Vraca sve rezervacije po ID sobe
     *
     * @param idSoba
     * @return List<Rezervacija>
     */
    @Override
    public List<Rezervacija> searchByIdSoba(Integer idSoba) {
        return rezervacijaRepository.findAllByIdSoba(idSoba);
    }

    /**
     * Vraca sve rezervacije po ID gost
     *
     * @param idGost
     * @return List<Rezervacija>
     */
    @Override
    public List<Rezervacija> searchByIdGost(Integer idGost) {
        return rezervacijaRepository.findAllByIdGosta(idGost);
    }

    /**
     * Vraca sve rezervacije po ID recepcioner
     *
     * @param idRecepcioner
     * @return List<Rezervacija>
     */
    @Override
    public List<Rezervacija> searchByIdRecepcioner(Integer idRecepcioner) {
        return rezervacijaRepository.findAllByIdRecepcioner(idRecepcioner);
    }


}
