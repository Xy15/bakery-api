package com.example.bakeryApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") //this class represents each document in the collection
@Data //getter & setter &  2 string methods
@AllArgsConstructor //create a constructor that take all these fields as arguments
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
}