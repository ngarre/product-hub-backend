package com.producthub.product_hub_backend.repository;

import com.producthub.product_hub_backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
