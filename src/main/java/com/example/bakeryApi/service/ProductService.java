package com.example.bakeryApi.service;

import com.example.bakeryApi.repository.ProductRepository;
import com.example.bakeryApi.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts(){    //Optional means it might returns null
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id){    //Optional means it might returns null
        return productRepository.findProductById(id);
    }

    public Product addProduct(Product productBody) {
        return productRepository.save(productBody);
    }

    public Optional<Product> removeProduct(String productId) {
        return productRepository.deleteById(productId);
    }
}
