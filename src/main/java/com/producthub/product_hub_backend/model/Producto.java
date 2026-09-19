package com.producthub.product_hub_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio;

    // This no-argument constructor allows JPA to create Producto objects
    // when loading products from the database
    protected Producto() {
    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    // GETTERS
    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }


    // SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }
}
