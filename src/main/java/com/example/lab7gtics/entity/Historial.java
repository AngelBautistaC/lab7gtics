package com.example.lab7gtics.entity;

import javax.persistence.*;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creditos_id", nullable = false)
    private Credito creditos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Credito getCreditos() {
        return creditos;
    }

    public void setCreditos(Credito creditos) {
        this.creditos = creditos;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

}