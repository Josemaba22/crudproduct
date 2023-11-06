package com.josemaba.crudproduct.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josemaba.crudproduct.entity.Product;
import com.josemaba.crudproduct.service.ProductSevice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    @Autowired
    private ProductSevice productSevice;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product request) {
        Product product = productSevice.createProduct(request);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/get/all")
    public List<Product> getAllProducts() {
        return productSevice.getAllProducts();
    }

    @GetMapping("/get/{id}")  
    public ResponseEntity<Product> getProductById(@RequestParam Long id) {
        Product product = productSevice.getProductById(id);
        return ResponseEntity.ok(product);
    }
    
}
