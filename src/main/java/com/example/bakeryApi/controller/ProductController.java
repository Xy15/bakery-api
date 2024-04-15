package com.example.bakeryApi.controller;

import com.example.bakeryApi.repository.ProductRepository;
import com.example.bakeryApi.service.ProductService;
import com.example.bakeryApi.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired  //use repository class and creating an object in other file (acts as a dependency injection)
    private ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> allProducts() {
        return new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Optional<Product>> singleProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/addProduct") //create new product or update existing product
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @PostMapping("/removeProduct/{id}")
    public ResponseEntity<Optional<Product>> removeProduct(@PathVariable("id") String productId) {
        return new ResponseEntity<>(productService.removeProduct(productId), HttpStatus.OK);
    }

}
