package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "rezervacija")
public class Rezervacija {
    @Id
    @Column(name = "ID_Rezervacije", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Gosta")
    private Gost idGosta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Sobe")
    private Soba idSobe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_Recepcioner", nullable = false)
    private Recepcioner idRecepcioner;

    @Column(name = "Datum_Rezervacije")
    private LocalDate datumRezervacije;

}