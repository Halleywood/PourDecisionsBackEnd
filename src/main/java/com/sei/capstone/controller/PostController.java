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
     * @return the UserProfile instance representing the current logged-in user.
     */
    public static UserProfile getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser().getUserProfile();
    }

    /**
     * Retrieves all of the posts related to a wine
     * @param wineId
     * @return List<Post>
     */
    @GetMapping("/wineposts/{wineId}")
    public List<Post> getPostsForWine(@PathVariable Long wineId){
        return postService.getAllPostsForWine(wineId);
    }

    /**
     * create a Post, receives the wine id, the user id, and the post information as a DTO. Then it is parsed out.
     * @param wineId
     * @param postDto
     * @return Post
     */
    @PostMapping("/posts/{wineId}")
    public Post createAPost(@PathVariable Long wineId, @RequestBody PostDTO postDto){
       return postService.createAPost(wineId,postDto);
    }

    /**
     * Get a single post by ID
     * @param postId
     * @return Post
     */
    @GetMapping("/posts/{postId}")
    public Post getOnePost(@PathVariable Long postId){
       return postService.getOnePost(postId);
    }

    /**
     * takes the postId and retrieves Post with that ID
     * @param postId
     * @param postObject
     * @return Post
     * @throws Exception if the user updating is not the user who created.
     */
    @PutMapping("/posts/{postId}")
    public Post updateAPost(@PathVariable Long postId, @RequestBody Post postObject) throws Exception {
      return postService.updatePost(postId, postObject);
    }

    /**
     * takes postId and deletes the Post with corresponding ID.
     * @param postId
     * @return  Response Code 204, NO CONTENT
     * @throws Exception if the user trying to delete is not the user who created
     */
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deleteAPost(@PathVariable Long postId) throws Exception {
        return postService.deleteAPost(postId);
    }


}
