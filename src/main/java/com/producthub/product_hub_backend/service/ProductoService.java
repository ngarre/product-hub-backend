package com.producthub.product_hub_backend.service;

import com.producthub.product_hub_backend.model.Producto;
import com.producthub.product_hub_backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }



    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(int id){
       return productoRepository.findById(id);
    }

    public Producto crearProducto(String nombre, double precio) {
        Producto productoCreado = new Producto(nombre, precio);
        return productoRepository.save(productoCreado);
    }

    public boolean eliminarProducto(int id) {
        Optional<Producto> producto = this.obtenerProductoPorId(id);

        if (producto.isEmpty()){
            return false;
        }

        // We can take the Product out of the Optional with get()
        // because we already checked that the Optional is not empty
        productoRepository.delete(producto.get());
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

        return Optional.of(productoRepository.save(producto));
    }
}
