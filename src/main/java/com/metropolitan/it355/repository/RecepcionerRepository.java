package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Recepcioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcionerRepository extends JpaRepository<Recepcioner,Integer> {
}
