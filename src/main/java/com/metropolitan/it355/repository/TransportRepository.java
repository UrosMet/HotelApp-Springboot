package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport , Integer> {
}
