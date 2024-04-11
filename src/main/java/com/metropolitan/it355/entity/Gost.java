package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gost")
public class Gost {
    @Id
    @Column(name = "ID_Gosta", nullable = false)
    private Integer id;

    @Column(name = "Ime", length = 50)
    private String ime;

    @Column(name = "Prezime", length = 50)
    private String prezime;

    @Column(name = "Datum_Dolaska")
    private LocalDate datumDolaska;

    @Column(name = "Datum_Odlaska")
    private LocalDate datumOdlaska;

    @Column(name = "Tip_Gosta", length = 10)
    private String tipGosta;

    @OneToMany(mappedBy = "idGosta")
    private Set<Rezervacija> listaRezervacija = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGosta")
    private Set<Transport> listaTransporta = new LinkedHashSet<>();

}