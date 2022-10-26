package com.example.lab7gtics.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
public class Solicitude {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "solicitud_producto", length = 45)
    private String solicitud_producto;

    @Column(name = "solicitud_monto")
    private Double solicitud_monto;

    @Column(name = "solicitud_fecha")
    private Instant solicitud_fecha;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuarios_id;

    @Column(name = "solicitud_estado", length = 45)
    private String solicitud_estado;


}