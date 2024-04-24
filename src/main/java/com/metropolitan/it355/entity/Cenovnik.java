package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cenovnik")
public class Cenovnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cenovnika", nullable = false)
    private Integer id;

    @Column(name = "Cena_Po_Noci", precision = 10, scale = 2)
    private BigDecimal cenaPoNoci;

}