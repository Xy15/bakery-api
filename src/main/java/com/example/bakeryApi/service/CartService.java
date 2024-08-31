package com.example.bakeryApi.service;

import com.example.bakeryApi.Cart;
import com.example.bakeryApi.CartItem;
import com.example.bakeryApi.repository.CartRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getCart(String userId){
        ObjectId userObjId = new ObjectId(userId);
        return cartRepository.findCartByUserId(userObjId);
    }

    public Cart addToCart(String userId, String productId, int quantity){
        ObjectId userObjId = new ObjectId(userId);
        Optional<Cart> cartOptional = cartRepository.findCartByUserId(userObjId);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                // If Product already added to Cart -> Update quantity
                if (cartItem.getProductId().equals(productId)) {
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    return cartRepository.save(cart);
                }
            }

            // Add new Product to Cart
            CartItem cartItem = new CartItem(productId, quantity);
            cartItems.add(cartItem);
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart not found");
        }
    }

    public Cart updateCart(String userId, String productId, int quantity){
        ObjectId userObjId = new ObjectId(userId);
        Optional<Cart> cartOptional = cartRepository.findCartByUserId(userObjId);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.updateCart(productId, quantity);
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart not found");
        }
    }
}