package com.departament.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EmployedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String cargo;
    private int departamentoId;

}
