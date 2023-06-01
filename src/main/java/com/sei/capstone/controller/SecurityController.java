package com.sei.capstone.controller;

import com.sei.capstone.exceptions.UserDoesNotExist;
import com.sei.capstone.exceptions.UserExistsException;
import com.sei.capstone.model.User;
import com.sei.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/auth")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path="/register")
    public ResponseEntity<?> registerUser(@RequestBody User userObject){
        Optional<User> checkingForUser = Optional.ofNullable(userRepository.findUserByEmail(userObject.getEmail()));
        if(checkingForUser.isEmpty()){
            User newUser = userRepository.save(userObject);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
        else{
            throw new UserExistsException("a user already exists with this email, please enter a unique email address");
        }
    }

//    @PostMapping(path="/login")
//    public User login(@RequestBody User userObject) {
//    }
}
