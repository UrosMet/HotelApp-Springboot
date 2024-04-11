package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Soba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobaRepository extends JpaRepository<Soba,Integer> {
}
