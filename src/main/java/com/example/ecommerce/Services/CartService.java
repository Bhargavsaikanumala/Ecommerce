package com.example.ecommerce.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Models.CartItem;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Repositories.CartRepository;
import com.example.ecommerce.Repositories.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public boolean addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            Optional<CartItem> existingItemOptional = cartRepository.findByProduct(product);
            if (existingItemOptional.isPresent()) {
                CartItem existingItem = existingItemOptional.get();
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                cartRepository.save(existingItem);
            } else {
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
                cartRepository.save(cartItem);
            }
            return true;
        } else {
            return false;
        }
    }
}
