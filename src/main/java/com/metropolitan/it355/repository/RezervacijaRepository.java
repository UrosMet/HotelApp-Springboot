package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija,Integer> {
}
