package com.example.lab7gtics.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "solicitudes")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSolicitudProducto() {
        return solicitud_producto;
    }

    public void setSolicitudProducto(String solicitudProducto) {
        this.solicitud_producto = solicitudProducto;
    }

    public Double getSolicitudMonto() {
        return solicitud_monto;
    }

    public void setSolicitudMonto(Double solicitudMonto) {
        this.solicitud_monto = solicitudMonto;
    }

    public Instant getSolicitudFecha() {
        return solicitud_fecha;
    }

    public void setSolicitudFecha(Instant solicitudFecha) {
        this.solicitud_fecha = solicitudFecha;
    }

    public Usuario getUsuarios() {
        return usuarios_id;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios_id = usuarios;
    }

    public String getSolicitudEstado() {
        return solicitud_estado;
    }

    public void setSolicitudEstado(String solicitudEstado) {
        this.solicitud_estado = solicitudEstado;
    }

}