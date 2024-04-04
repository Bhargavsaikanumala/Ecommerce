package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Models.UserModel;
import com.example.ecommerce.Services.UserService;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserModel user) {
        return userService.register(user);

    }

    @GetMapping("/login/{username}")
    public boolean auth(@PathVariable("username") String username, @RequestHeader String password) {
        return userService.authenticate(username, password);
    }

}