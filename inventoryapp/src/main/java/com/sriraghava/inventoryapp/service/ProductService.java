package com.sriraghava.inventoryapp.service;

import com.sriraghava.inventoryapp.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    List<Product> getAllproducts();

    Product getProductByBarcode(String barcode);
    Product updateQuantity(Long id, int quantity);
    void deleteProduct(Long id);

}
