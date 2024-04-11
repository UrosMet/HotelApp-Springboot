package com.metropolitan.it355.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "soba")
public class Soba {
    @Id
    @Column(name = "ID_Sobe", nullable = false)
    private Integer id;

    @Column(name = "BrojKreveta")
    private Integer brojKreveta;

    @Column(name = "TipKreveta", length = 50)
    private String tipKreveta;

    @Column(name = "Klima")
    private Boolean klima;

}