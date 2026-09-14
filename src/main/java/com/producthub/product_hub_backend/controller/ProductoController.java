package com.producthub.product_hub_backend.controller;

import com.producthub.product_hub_backend.dto.CrearProductoRequest;
import com.producthub.product_hub_backend.model.Producto;
import com.producthub.product_hub_backend.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable int id) {
        Optional<Producto> respuesta = this.productoService.obtenerProductoPorId(id);

        if (respuesta.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Producto producto = respuesta.get();
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(
            @RequestBody CrearProductoRequest request
            ) {
        String productoNuevoNombre = request.getNombre();
        double productoNuevoPrecio = request.getPrecio();

        Producto producto = productoService.crearProducto(productoNuevoNombre, productoNuevoPrecio);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(producto);
    }
}
