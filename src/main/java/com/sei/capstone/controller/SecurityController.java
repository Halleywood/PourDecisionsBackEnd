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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import java.security.SecureRandom;
import java.util.Base64;
import java.security.SecureRandom;
import java.util.Base64;


@RestController
@RequestMapping(path="/auth")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtils jwUtils;
    private AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;
    private UserProfileRepository userProfileRepository;

    public SecurityController(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager, @Lazy MyUserDetails myUserDetails, UserProfileRepository userProfileRepository ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
        this.userProfileRepository = userProfileRepository;
    }

    @PostMapping(path="/register")
    public ResponseEntity<?> registerUser(@RequestBody User userObject){
        if(!userRepository.existsByEmail(userObject.getEmail())){
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            UserProfile defaultProfile = new UserProfile();
            userProfileRepository.save(defaultProfile);
            userObject.setUserProfile(defaultProfile);
            User newUser = userRepository.save(userObject);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
        else{
            throw new UserExistsException("a user already exists with this email, please enter a unique email address");
        }
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final String JWT = jwUtils.generateJwtToken(myUserDetails);
            System.out.println(ResponseEntity.ok(new LoginResponse(JWT)));
            return ResponseEntity.ok(new LoginResponse(JWT));
        } catch(Exception e){
            return ResponseEntity.ok(new LoginResponse("Error: username or password is incorrect"));
        }
    }



}
