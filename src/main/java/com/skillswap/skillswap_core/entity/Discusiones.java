package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "discuciones")
@Data
public class Discusiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discusionesId;
    private String titulo;
    private String descripcion;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario obj_Usuario;

    @ManyToOne
    @JoinColumn(name = "foroId")
    private Foros obj_Foro;

    @JsonIgnore
    @OneToMany(mappedBy = "obj_Discuciones",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Respuestas>  respuestas = new ArrayList<>();
}
