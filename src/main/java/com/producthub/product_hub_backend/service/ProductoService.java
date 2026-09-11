package com.producthub.product_hub_backend.service;

import com.producthub.product_hub_backend.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {


    public List<Producto> obtenerProductos(){
        return List.of(
                new Producto(1, "lapicero", 12.5),
                new Producto(2, "cuaderno", 8),
                new Producto(3, "rotulador", 5)
        );
    }
}
