package com.example.ecommerce.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Models.UserModel;
import com.example.ecommerce.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public ResponseEntity<String> register(UserModel userModel) {
        
        try {
            UserModel user = userRepository.findByUsername(userModel.getUsername());
            if(user==null){
                String hashedPassword = PasswordUtil.encodePassword(userModel.getPassword());
            userModel.setPassword(hashedPassword);
            userRepository.save(userModel);
            return ResponseEntity.status(HttpStatus.OK).body("Registration Successful");
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
            }
            
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    
    public boolean authenticate(String username,String password)
    {
        UserModel userModel = userRepository.findByUsername(username);
        if (userModel==null) {
            return false;
        }
        else
        {
            return PasswordUtil.checkPassword(password,userModel.getPassword());
        }
    } 
}
