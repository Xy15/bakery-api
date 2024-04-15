package com.example.bakeryApi.repository;

import com.example.bakeryApi.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //fetch data from mongodb compass
//allows CRUD operations on Product entities stored in a MongoDB collection
// without having to write the implementation code yourself
public interface ProductRepository extends MongoRepository<Product, ObjectId> { //class name and primary key data type
    //can form dynamic queries here using any property name

    //create a query to search for a single product using id
    Optional<Product> findProductById(String id);   //by naming it findMovieByImdbId, Spring Data MongoDB understand what we want
    Optional<Product> deleteById(String id);
}
