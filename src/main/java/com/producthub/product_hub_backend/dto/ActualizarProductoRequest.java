package com.producthub.product_hub_backend.dto;

public class ActualizarProductoRequest {
    private String nombre;
    private double precio;

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }
}
