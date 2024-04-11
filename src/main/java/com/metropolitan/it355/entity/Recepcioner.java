package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recepcioner")
public class Recepcioner {
    @Id
    @Column(name = "ID_Recepcionera", nullable = false)
    private Integer id;

    @Column(name = "Ime", length = 50)
    private String ime;

    @Column(name = "Prezime", length = 50)
    private String prezime;

    @Column(name = "KorisnickoIme", length = 50)
    private String korisnickoIme;

    @Column(name = "Lozinka", length = 50)
    private String lozinka;

    @OneToMany(mappedBy = "idRecepcioner")
    private Set<Rezervacija> listaRezervacija = new LinkedHashSet<>();

}