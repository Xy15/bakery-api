package com.example.bakeryApi.service;

import com.example.bakeryApi.Cart;
import com.example.bakeryApi.repository.CartRepository;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.slf4j.Logger;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

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
//        Query query = new Query();
//        query.addCriteria(new Criteria().orOperator(
//                Criteria.where("field1").is("value1"),
//                Criteria.where("field2").is("value2")
//                ));
//        query.addCriteria(new Criteria().orOperator(
//                Criteria.where("field3").is("value3"),
//                Criteria.where("field3").is(null),
//                Criteria.where("field3").exists(false),
//                ));

//
//        Cart cart = cartRepository.save();
//        Query query = new Query(Criteria.where("userId").is(userId)
//                .and("productId").is(productId));
//        Update update = new Update().inc("quantity", quantity);
//        mongoTemplate.updateFirst(query, update, Cart.class);
//        return cart;