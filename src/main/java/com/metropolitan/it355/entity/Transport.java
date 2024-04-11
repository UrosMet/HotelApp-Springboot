package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Transporta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Gosta")
    private Gost idGosta;

    @Column(name = "VrstaTransporta", length = 50)
    private String vrstaTransporta;

    @Column(name = "VremeNarucivanja")
    private Instant vremeNarucivanja;

}