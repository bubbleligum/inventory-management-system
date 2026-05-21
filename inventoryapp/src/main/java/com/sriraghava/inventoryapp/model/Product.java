package com.sriraghava.inventoryapp.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String barcode;
    private double price;
    private int quantity;
    private String category;
    private String supplierName;
    private int lowStockThreshold;

}
