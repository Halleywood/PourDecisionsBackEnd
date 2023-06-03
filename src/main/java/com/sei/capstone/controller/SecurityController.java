package com.sei.capstone.controller;

import com.sei.capstone.exceptions.UserDoesNotExist;
import com.sei.capstone.exceptions.UserExistsException;
import com.sei.capstone.model.User;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.model.login.LoginRequest;
import com.sei.capstone.model.login.LoginResponse;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.security.JWTUtils;
import com.sei.capstone.security.MyUserDetails;
import com.sei.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import java.security.SecureRandom;
import java.util.Base64;
import java.security.SecureRandom;
import java.util.Base64;


@RestController
@RequestMapping(path="/auth")
@CrossOrigin
public class SecurityController {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtils jwUtils;
    private AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;
    private UserProfileRepository userProfileRepository;

    private UserService userService;

    @Autowired
    public SecurityController(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager, @Lazy MyUserDetails myUserDetails, UserProfileRepository userProfileRepository, UserService userService ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
        this.userProfileRepository = userProfileRepository;
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

    @GetMapping(path="/test")
    public String testMethod(){
        return "HELLO FROM THE TEST METHOD! 👀";
    }



}
