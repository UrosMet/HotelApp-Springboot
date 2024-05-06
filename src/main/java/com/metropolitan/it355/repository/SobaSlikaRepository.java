package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.SobaSlika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SobaSlikaRepository extends JpaRepository<SobaSlika, Integer> {

    @Query(value = "SELECT * FROM soba_slika WHERE Id_Soba = :idSoba" , nativeQuery = true)
    List<SobaSlika> findAllByIdSoba(Integer idSoba);

}
