package com.sei.capstone.controller;

import com.sei.capstone.model.User;
import com.sei.capstone.model.login.LoginRequest;
import com.sei.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Security Controller handles login/registration requests. Calls User Service for all business logic.
 */
@RestController
@RequestMapping(path="/auth")
@CrossOrigin("*")
public class SecurityController {

    private UserService userService;

    @Autowired
    public SecurityController(UserService userService ){
        this.userService = userService;
    }

    @PostMapping(path="/register")
    public ResponseEntity<?> registerUser(@RequestBody User userObject){
       return userService.registerUser(userObject);
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
       return userService.login(loginRequest);
    }

}
