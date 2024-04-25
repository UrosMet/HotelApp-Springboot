package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija,Integer> {

    @Query(value = "SELECT * FROM rezervacija WHERE ID_Gosta = :idGosta" , nativeQuery = true)
    List<Rezervacija> findAllByIdGosta(Integer idGosta);

    @Query(value = "SELECT * FROM rezervacija WHERE ID_Recepcioner = :idRecepcioner" , nativeQuery = true)
    List<Rezervacija> findAllByIdRecepcioner(Integer idRecepcioner);

    @Query(value = "SELECT * FROM rezervacija WHERE ID_Sobe = :idSoba" , nativeQuery = true)
    List<Rezervacija> findAllByIdSoba(Integer idSoba);

    @Query(value = "SELECT SUM(c.Cena_Po_Noci * r.Duzina_Boravka) AS Ukupna_Zarada\n" +
            "FROM rezervacija r\n" +
            "JOIN soba s ON r.ID_Sobe = s.ID_Sobe\n" +
            "JOIN cenovnik c ON s.ID_Cenovnik = c.ID_Cenovnika" , nativeQuery = true)
    Double totaEarnings();

    @Query(value = "SELECT SUM(c.Cena_Po_Noci * r.Duzina_Boravka) " +
            "FROM rezervacija r " +
            "JOIN soba s ON r.ID_Sobe = s.ID_Sobe " +
            "JOIN cenovnik c ON s.ID_Cenovnik = c.ID_Cenovnika " +
            "WHERE r.Datum_Rezervacije >= :startDate AND r.Datum_Rezervacije <= :endDate",
            nativeQuery = true)
    Double totalEarningsForPeriod(LocalDate startDate, LocalDate endDate);

}
