package com.producthub.product_hub_backend.controller;

import com.producthub.product_hub_backend.model.Producto;
import com.producthub.product_hub_backend.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    // Spring injects ProductoService through the constructor.
    // This makes the dependency required, and final prevents changing the reference later.
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }



    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos(){
        List<Producto> productos = productoService.obtenerProductos();

        return ResponseEntity.ok(productos);
    }
}
