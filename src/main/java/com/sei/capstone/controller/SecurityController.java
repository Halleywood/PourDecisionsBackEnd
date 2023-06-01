package com.sei.capstone.controller;

import com.sei.capstone.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/auth")
public class SecurityController {

    @PostMapping(path="/register")
    public User registerUser(@RequestBody User userObject){

    }

    @PostMapping(path="/login")
    public User login(@RequestBody User userObject){

    }
}
