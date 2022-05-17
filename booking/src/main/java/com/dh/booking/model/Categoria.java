package com.dh.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "categorias")
public class Categoria {

    //* ///////// ATTRIBUTES ///////// *//

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descripcion;
    private String urlImagen;
}


