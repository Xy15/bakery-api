package com.example.bakeryApi.controller;

import com.example.bakeryApi.Cart;
import com.example.bakeryApi.service.CartService;
import com.example.bakeryApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/getCart/{userId}")
    public ResponseEntity<Optional<Cart>> getCart(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(cartService.getCart(userId), HttpStatus.OK);
    }

    @PatchMapping("/updateCart")
    public ResponseEntity<Cart> updateCart(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(cartService.updateCart(payload.get("userId"), payload.get("productId"), Integer.parseInt(payload.get("quantity"))), HttpStatus.OK);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<Cart> addToCart(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(cartService.addToCart(payload.get("userId"), payload.get("productId"), Integer.parseInt(payload.get("quantity"))), HttpStatus.OK);
    }
}
