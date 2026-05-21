package com.sriraghava.inventoryapp.service;

import com.sriraghava.inventoryapp.exception.ProductNotFoundException;
import com.sriraghava.inventoryapp.model.Product;
import com.sriraghava.inventoryapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    public ProductServiceImp (ProductRepository productRepository){
        this.productRepository= productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);

    }

    @Override
    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByBarcode(String barcode){
        return productRepository.findByBarcode(barcode)
                .orElseThrow(()->  new ProductNotFoundException("Product not found"));
    }

    @Override
    public Product updateQuantity(Long id, int quantity){
        Product product=productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        product.setQuantity(quantity);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id){
        Product product= productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
    }


}
