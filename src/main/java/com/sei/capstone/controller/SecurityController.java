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

    /**
     * Sends a userObject as a request body to add as a user.
     * @param userObject
     * @return Response code 201 for created. Throws exception if email not unique.
     */
    @PostMapping(path="/register")
    public ResponseEntity<?> registerUser(@RequestBody User userObject){
       return userService.registerUser(userObject);
    }

    /**
     * sends  loginRequest as request body, consists of String email and String password
     * @param loginRequest
     * @return if email and password match what is in DB, returns ResponseEntity with 200ok status code and JWT as response body.
     */
    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
       return userService.login(loginRequest);
    }

}
