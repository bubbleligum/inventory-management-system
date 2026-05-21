package com.sriraghava.inventoryapp.repository;

import com.sriraghava.inventoryapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByBarcode(String Barcode);

}
