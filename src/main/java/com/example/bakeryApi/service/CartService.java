package com.example.bakeryApi.service;

import com.example.bakeryApi.Cart;
import com.example.bakeryApi.repository.CartRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getCart(String userId){
        ObjectId userObjId = new ObjectId(userId);
        return cartRepository.findCartByUserId(userObjId);
    }

    public Cart updateCart(String userId, String productId, int quantity){
        ObjectId userObjId = new ObjectId(userId);
        Optional<Cart> cartOptional = cartRepository.findCartByUserId(userObjId);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.updateCart(productId, quantity);

            return cartRepository.save(cart);
        } else {
            // when user's cart is not found
            return null;
        }
    }
}