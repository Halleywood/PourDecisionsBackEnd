package com.sei.capstone.controller;

import com.sei.capstone.model.Post;
import com.sei.capstone.model.PostDTO;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.security.MyUserDetails;
import com.sei.capstone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    public PostController(PostService postService){
        this.postService = postService;
    }

    /**
     * Retrieves the current logged-in user profile.
     * @return the User instance representing the current logged-in user.
     */
    public static UserProfile getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser().getUserProfile();
    }
    @GetMapping("/wineposts/{wineId}")
    public List<Post> getPostsForWine(@PathVariable Long wineId){
        return postService.getAllPostsForWine(wineId);
    }
    @PostMapping("/posts/{wineId}")
    public Post createAPost(@PathVariable Long wineId, @RequestBody PostDTO postDto){
       return postService.createAPost(wineId,postDto);
    }
    @GetMapping("/posts/{postId}")
    public Post getOnePost(@PathVariable Long postId){
       return postService.getOnePost(postId);
    }

    @PutMapping("/posts/{postId}")
    public Post updateAPost(@PathVariable Long postId, @RequestBody Post postObject) throws Exception {
      return postService.updatePost(postId, postObject);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deleteAPost(@PathVariable Long postId) throws Exception {
        return postService.deleteAPost(postId);
    }

}
