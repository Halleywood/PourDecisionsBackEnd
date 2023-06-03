package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Post;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.PostRepository;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.WineRepository;
import com.sei.capstone.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepo;
    private UserProfileRepository userProfileRepo;
    private WineRepository wineRepo;


    public PostController(PostRepository postRepo, UserProfileRepository userProfileRepo, WineRepository wineRepository ){
        this.postRepo = postRepo;
        this.userProfileRepo = userProfileRepo;
        this.wineRepo = wineRepository;
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
    @PostMapping("/post/{wineId}")
    public Post createAPost(@PathVariable Long wineId, @RequestBody Post postObject){
        //make sure the wine exists first.
        Optional<Wine> wine = wineRepo.findById(wineId);
        if(wine.isPresent()){
            //save the post object.
            postObject.setUserProfile(getCurrentLoggedInUser());
            postObject.setWine(wine.get());
            Post newPost = postRepo.save(postObject);
            //save the post to the User's list of posts
            UserProfile userProfile = getCurrentLoggedInUser();
            List<Post> userPosts = userProfile.getUserPosts();
            userPosts.add(postObject);
            userProfile.setUserPosts(userPosts);
            //save the post to the Posts about this wine.
            List<Post> winePosts = wine.get().getPostsAboutThisWine();
            winePosts.add(newPost);
            wine.get().setPostsAboutThisWine(winePosts);
            return newPost;
        }
        else{
            throw new InformationNotFoundException("No wine with id " + wineId);
        }
    }

//    @PutMapping("/post/{postId}")
//    public Post updateAPost(){
//        //can get wine id from post...and user id must match who wrote it...
//    }
//    @DeleteMapping("/post/{postId}")
//    public Post deleteAPost(){
//        //must be the person who wrote it!
//    }

}
