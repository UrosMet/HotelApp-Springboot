package com.metropolitan.it355.services;

import com.metropolitan.it355.entity.Recepcioner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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
    Optional<?> getById(int id);

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

    /**
     * Metoda dodaje ili updejtuje sliku
     * @param file
     * @return path
     */
    String storeImage(MultipartFile file);

    /**
     * Metoda updatejtuje recepcionera i dodaje sliku u folder
     * @param id
     * @param ime
     * @param prezime
     * @param korisnicko_ime
     * @param lozinka
     * @param profilna_slika
     * @param role
     * @return Recepcioner
     */
    Recepcioner updateRecepcioner(int id, String ime, String prezime, String korisnicko_ime, String lozinka, MultipartFile profilna_slika, String role);

    void deleteRecepcionerAndImage(int id);

}
