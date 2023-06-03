package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Post;
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

    @GetMapping("/profile/{userProfileId}")
    public UserProfile getOneProfile(@PathVariable Long userProfileId) {
      return userService.getOneProfile(userProfileId);
    }

    @PutMapping("/profile/{userProfileId}")
    public UserProfile updateUserProfile(@PathVariable Long userProfileId, @RequestBody UserProfile profileObject) {
        return userService.updateUserProfile(userProfileId, profileObject);
    }

    @GetMapping("/profile/{userProfileId}/posts")
    public List<Post> getPostsOfAUser(@PathVariable Long userProfileId){
        return userService.getPostsOfUser(userProfileId);
    }

    @GetMapping("/profile/posts")
    public List<Post> getAllYourPosts() {
        return userService.getAllYourPosts();
    }
}
