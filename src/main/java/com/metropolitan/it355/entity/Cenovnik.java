package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "cenovnik")
public class Cenovnik {
    @Id
    @Column(name = "ID_Cenovnika", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Sobe")
    private Soba idSobe;

    @Column(name = "Cena_Po_Noci", precision = 10, scale = 2)
    private BigDecimal cenaPoNoci;

}