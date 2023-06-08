package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Post;
import com.sei.capstone.model.User;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.repository.WineRepository;
import com.sei.capstone.security.MyUserDetails;
import com.sei.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService userService;


    private UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves the UserProfile of logged user, obtains userId from currentLoggedInUser behind scenes.
     * @return UserProfile
     */
    @GetMapping(path="/get-user")
    public UserProfile getLoggedInUser(){
        return userService.getCurrentUser();
    }

    /**
     * Retrieves a list with matching userID of logged in user ID
     * @return List<Post>
     */
    @GetMapping("/profile/posts")
    public List<Post> getAllYourPosts() {
        return userService.getAllYourPosts();
    }
}
