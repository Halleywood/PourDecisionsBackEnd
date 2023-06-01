package com.sei.capstone.controller;

import com.sei.capstone.exceptions.UserDoesNotExist;
import com.sei.capstone.exceptions.UserExistsException;
import com.sei.capstone.model.User;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.security.JWTUtils;
import com.sei.capstone.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@RequestMapping(path="/auth")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtils jwUtils;
    private AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;

    public SecurityController(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager, @Lazy MyUserDetails myUserDetails ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
    }

    @PostMapping(path="/register")
    public ResponseEntity<?> registerUser(@RequestBody User userObject){
        if(!userRepository.existsByEmail(userObject.getEmail())){
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            userObject.setUserProfile(new UserProfile("You will need to create a username!", "You will need to create a tagline!", "https://png.pngitem.com/pimgs/s/111-1114675_user-login-person-man-enter-person-login-icon.png"));
            User newUser = userRepository.save(userObject);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
        else{
            throw new UserExistsException("a user already exists with this email, please enter a unique email address");
        }
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody User userObject) {
        return (ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(userObject));
    }
}
