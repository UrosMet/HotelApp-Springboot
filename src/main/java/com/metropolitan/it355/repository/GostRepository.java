package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Gost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GostRepository extends JpaRepository<Gost , Integer> {
}
