package com.example.bakeryApi.repository;

import com.example.bakeryApi.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, ObjectId> {
    Optional<Cart> findCartByUserId(ObjectId userId);
}
