package com.example.bakeryApi.service;

import com.example.bakeryApi.Cart;
import com.example.bakeryApi.CartItem;
import com.example.bakeryApi.Product;
import com.example.bakeryApi.repository.CartRepository;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;
import org.slf4j.Logger;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    public Optional<Cart> getCart(String id){    //Optional means it might returns null
        ObjectId userId = new ObjectId(id);
        return cartRepository.findCartByUserId(userId);
    }

    public Cart updateCart(String userId, String productId, int quantity){
            ObjectId userObjId = new ObjectId(userId);
            Optional<Cart> cartOptional = cartRepository.findCartByUserId(userObjId);

            if (cartOptional.isPresent()) {
                Cart cart = cartOptional.get();
                ObjectId productObjId = new ObjectId(productId);
                cart.updateCart(productObjId, quantity);

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