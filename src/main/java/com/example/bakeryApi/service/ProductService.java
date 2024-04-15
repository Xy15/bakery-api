package com.example.bakeryApi.service;

import com.example.bakeryApi.repository.ProductRepository;
import com.example.bakeryApi.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> allProducts(){    //Optional means it might returns null
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id){    //Optional means it might returns null
        return productRepository.findProductById(id);
    }

    public Product addProduct(Product productBody) {
        return productRepository.save(productBody);
    }

    public void removeProduct(String productId) {
        productRepository.deleteById(productId);
    }
}
