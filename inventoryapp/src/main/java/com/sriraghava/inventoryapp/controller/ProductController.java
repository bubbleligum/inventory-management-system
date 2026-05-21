package com.sriraghava.inventoryapp.controller;

import com.sriraghava.inventoryapp.model.Product;
import com.sriraghava.inventoryapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);

    }
    @GetMapping
    public List<Product> getAllproducts(){
        return productService.getAllproducts();
    }

    @GetMapping("/barcode/{barcode}")
    public Product getProductByBarcode(@PathVariable String barcode){
        return productService.getProductByBarcode(barcode);

    }

    @PutMapping("/{id}/quantity")
    public Product updateQuantity(@PathVariable long id, @RequestParam int quantity){
        return productService.updateQuantity(id, quantity);

    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id){
        return "Product deleted successfully";

    }



}
