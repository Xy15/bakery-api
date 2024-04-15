package com.example.bakeryApi;

import com.example.bakeryApi.service.CartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.logging.Logger;

@Document(collection = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private String id;
    private List<CartItem> products;
    private ObjectId userId;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CartService.class);

    public void updateCart(ObjectId productId, int quantity) {
        if (products != null) {
            for (CartItem item : products) {
                if (item.getProductId().equals(productId)) {
                    item.setQuantity(quantity);
                    return;
                }
            }
        }
        CartItem newItem = new CartItem(productId, quantity);
        products.add(newItem);
    }
}
