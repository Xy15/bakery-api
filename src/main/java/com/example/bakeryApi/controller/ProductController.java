package com.example.bakeryApi.controller;

import com.example.bakeryApi.repository.ProductRepository;
import com.example.bakeryApi.service.ProductService;
import com.example.bakeryApi.Product;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired  //use repository class and creating an object in other file (acts as a denpendency injection)
    private ProductRepository productRepository;

    @GetMapping("/users")
    public ResponseEntity<String> allUsers() {
        return new ResponseEntity<>("123", HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> allProducts() {
        return new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
    }

    @GetMapping("/getSingleProduct/{id}")
    public ResponseEntity<Optional<Product>> singleProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/addProduct") //create new product or update existing product
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @PostMapping("/removeProduct/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable("id") String productId) {
        productService.removeProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
