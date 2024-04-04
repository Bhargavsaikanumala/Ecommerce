package com.example.ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
