package com.javatest.javatest.models;

import jakarta.persistence.*;


@Entity
@Table(name = "lenguajes")
public class Lenguajes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Long id;
    @Column(name="nombre")
    public String nombre;
    @Column(name="fecha")
    public String fecha;

    public Lenguajes() {
    }

    public Lenguajes(String nombre, String fecha){
        this.fecha=fecha;
        this.nombre=nombre;
    }
}
