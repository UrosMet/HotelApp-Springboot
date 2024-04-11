package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Cenovnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik , Integer> {
}
