package com.example.lab7gtics.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@Table(name = "pagos")
public class Pago {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "monto")
    private Double monto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuarios;

    @Column(name = "tipo_pago", length = 45)
    private String tipoPago;

    @Column(name = "fecha")
    private Instant fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "creditos_id", nullable = false)
    private Credito creditos;

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }
}