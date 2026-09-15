package com.producthub.product_hub_backend.service;

import com.producthub.product_hub_backend.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private int siguienteId = 4;

    private final List<Producto> productos = new ArrayList<>(
            List.of(
                    new Producto(1, "lapicero", 12.5),
                    new Producto(2, "cuaderno", 8),
                    new Producto(3, "rotulador", 5)
            )
    );


    public List<Producto> obtenerProductos(){
        return productos;
    }

    public Optional<Producto> obtenerProductoPorId(int id){
        for (Producto producto: productos) {
            if (producto.getId() == id ){
                return Optional.of(producto);
            }
        }

        return Optional.empty();
    }

    public Producto crearProducto(String nombre, double precio) {
        Producto productoCreado = new Producto(siguienteId, nombre, precio);
        siguienteId++;
        productos.add(productoCreado);
        return productoCreado;
    }

    public boolean eliminarProducto(int id) {
        Optional<Producto> producto = this.obtenerProductoPorId(id);

        if (producto.isEmpty()){
            return false;
        }

        // We can take the Product out of the Optional with get()
        // because we already checked that the Optional is not empty
        productos.remove(producto.get());
        return true;
    }

    public Optional<Producto> actualizarProductoPorId(int id, String nuevoNombre, double nuevoPrecio){
        Optional<Producto> productoBuscado = this.obtenerProductoPorId(id);

        if (productoBuscado.isEmpty()){
           return Optional.empty();
        }

        Producto producto = productoBuscado.get();
        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);

        // It is not necessary to search again in the ArrayList
        // because productoBuscado contains a reference to the same Producto object stored in productos
        return productoBuscado;
    }

}
