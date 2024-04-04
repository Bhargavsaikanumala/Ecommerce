package com.example.ecommerce.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Models.CartItem;
import com.example.ecommerce.Models.Product;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByProduct(Product product);

}
