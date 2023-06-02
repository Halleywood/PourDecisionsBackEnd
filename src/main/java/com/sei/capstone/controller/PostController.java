package com.sei.capstone.controller;

import com.sei.capstone.model.Post;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.repository.PostRepository;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepo;
    private UserProfileRepository userProfileRepo;


    public PostController(PostRepository postRepo, UserProfileRepository userProfileRepo ){
        this.postRepo = postRepo;
        this.userProfileRepo = userProfileRepo;
    }

    /**
     * Retrieves the current logged-in user profile.
     * @return the User instance representing the current logged-in user.
     */
    public static UserProfile getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser().getUserProfile();
    }

    @GetMapping("/posts/{wineId}")
    public List<Post> getPostsForWine(@PathVariable Long wineId){
        return postRepo.findAllByWineId(wineId);
    }

//    @GetMapping("/posts/{profileId}")
//    public List<Post> getPostsOfAUser(@PathVariable Long profileId){
//        return postRepo.findPostsByUserProfile(profileId);
//    }

//    @GetMapping("/posts")
//    public List<Post> getAllPostsFromUser(){
//        //get profile id form logged in...display list.
//    }

//    @PostMapping("/post/{wineId}")
//    public Post createAPost(){
//        //need userId and wineID.
//    }

//    @PutMapping("/post/{postId}")
//    public Post updateAPost(){
//        //can get wine id from post...and user id must match who wrote it...
//    }
//    @DeleteMapping("/post/{postId}")
//    public Post deleteAPost(){
//        //must be the person who wrote it!
//    }

}
