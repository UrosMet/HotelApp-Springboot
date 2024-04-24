package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "soba")
public class Soba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Sobe", nullable = false)
    private Integer id;

    @Column(name = "Broj_Kreveta")
    private Integer brojKreveta;

    @Column(name = "Tip_Kreveta", length = 50)
    private String tipKreveta;

    @Column(name = "Klima")
    private Boolean klima;

}