package com.example.bakeryApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private ObjectId id;
    private List<CartItem> products;
    private ObjectId userId;

    public void updateCart(String productId, int quantity) {
        for (CartItem item : products) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(quantity);
                return;
            }
        }
        CartItem newItem = new CartItem(productId, quantity);
        products.add(newItem);
    }
}
