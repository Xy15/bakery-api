package com.example.bakeryApi.repository;

import com.example.bakeryApi.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //fetch data from mongodb compass
public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    Optional<Product> findProductById(String id);
    Optional<Product> deleteById(String id);
}
