package com.example.bakeryApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products") //this class represents each document in the collection
@Data //getter & setter &  2 string methods
@AllArgsConstructor //create a constructor that take all these fields as arguments
@NoArgsConstructor  //create an empty constructor that take no parameters
public class Product {
    @Id
    private String id;
    private String prodName;
    private String description;
    private String category;
    private Double price;
    private String image;

}
