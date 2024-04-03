package com.example.ecommerce.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel,UUID> {
    UserModel findByUsername(String username);
}

