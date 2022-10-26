package com.example.lab7gtics.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

@Table(name = "rol")
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_rol", length = 45)
    private String nombreRol;

}