package com.producthub.product_hub_backend.service;

import com.producthub.product_hub_backend.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {


    public List<Producto> obtenerProductos(){
        return List.of(
                new Producto(1, "lapicero", 12.5),
                new Producto(2, "cuaderno", 8),
                new Producto(3, "rotulador", 5)
        );
    }

    public Optional<Producto> obtenerProductoPorId(int id){
        List<Producto> productosDisponibles = this.obtenerProductos();
        for (Producto producto: productosDisponibles) {
            if (producto.getId() == id ){
                return Optional.of(producto);
            }
        }

        return Optional.empty();
    }
}
