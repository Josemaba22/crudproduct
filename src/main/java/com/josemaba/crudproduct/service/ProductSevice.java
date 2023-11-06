package com.josemaba.crudproduct.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josemaba.crudproduct.entity.Product;
import com.josemaba.crudproduct.repository.ProductRepository;

@Service
public class ProductSevice {
    
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.id).orElse(null);
        existingProduct.name = product.name;
        existingProduct.description = product.description;
        existingProduct.price = product.price;
        existingProduct.category = product.category;
        existingProduct.stock = product.stock;
        return productRepository.save(existingProduct);
    }

    public Product deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        productRepository.delete(existingProduct);
        return existingProduct;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    
}
