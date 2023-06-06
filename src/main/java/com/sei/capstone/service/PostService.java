package com.sei.capstone.service;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Post;
import com.sei.capstone.model.PostDTO;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.PostRepository;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.WineRepository;
import com.sei.capstone.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;
    private WineRepository wineRepo;
    private UserProfileRepository profileRepo;

    public PostService(PostRepository postRepo, WineRepository wineRepository, UserProfileRepository profileRepo){
        this.postRepo = postRepo;
        this.wineRepo = wineRepository;
        this.profileRepo = profileRepo;
    }

    /**
     * Retrieves the current logged-in user profile.
     * @return the User instance representing the current logged-in user.
     */
    public static UserProfile getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser().getUserProfile();
    }

    public List<Post> getAllPostsForWine(Long wineId){
        return postRepo.findAllByWineId(wineId);
    }

    public Post createAPost(Long wineId, PostDTO postDto){
        //make sure the wine exists first.
        Optional<Wine> wine = wineRepo.findById(wineId);
        if(wine.isPresent()) {
            //if the object contains any null fields, send it back.
            if (!checkAllFields(postDto)) {
                throw new MissingFormatArgumentException("All fields must contain a value!");
            } else {
                //save the post object.

                Post newPost = new Post();
                newPost.setUserProfile(getCurrentLoggedInUser());
                newPost.setTitle(postDto.getTitle());
                newPost.setTastingNotes(postDto.getTastingNotes());
                newPost.setRating(postDto.getRating());
                newPost.setImgSrc(postDto.getImgSrc());
                newPost.setWine(wine.get());


                List<Post> userPosts = getCurrentLoggedInUser().getUserPosts();
                userPosts.add(newPost);
                getCurrentLoggedInUser().setUserPosts(userPosts);

                postRepo.save(newPost);

                //save the post to the Posts about this wine.
                List<Post> winePosts = wine.get().getPostsAboutThisWine();
                winePosts.add(newPost);
                wine.get().setPostsAboutThisWine(winePosts);
                return newPost;
            }
        }
        else{
            throw new InformationNotFoundException("No wine with id " + wineId);
        }
    }
    public Post getOnePost(Long postId){
        Optional<Post> post = postRepo.findById(postId);
        if(post.isPresent()){
            return post.get();
        }
        else{
            throw new InformationNotFoundException("No post with this id exists!");
        }
    }

    public Post updatePost(Long postId, Post postObject) throws Exception {
        //will throw the exception if not found.
        Post postToUpdate = getOnePost(postId);
        if(postToUpdate.getUserProfile().getId() == getCurrentLoggedInUser().getId()){
            if(postObject.getTitle() != null){
                postToUpdate.setTitle(postObject.getTitle());
            }
            if(postObject.getTastingNotes() != null){
                postToUpdate.setTastingNotes(postObject.getTastingNotes());
            }
            if(postObject.getRating() != null){
                postToUpdate.setRating(postObject.getRating());
            }
            if(postObject.getImgSrc() != null){
                postToUpdate.setImgSrc(postObject.getImgSrc());
            }
            postRepo.save(postToUpdate);
            return postToUpdate;
        }
        else{
            throw new Exception("You can only update posts that you have created!");
        }
    }

    public ResponseEntity<?> deleteAPost(Long postId) throws Exception{
        Post postToDelete = getOnePost(postId);
        if(postToDelete.getUserProfile().getId() == getCurrentLoggedInUser().getId()) {
            postRepo.delete(postToDelete);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Post has been deleted successfully");
        }
        else{
            throw new Exception("You must be the user who created this post to delete it!");
        }
    }
    /**
     * CREATED THIS HELP METHOD TO VERIFY ALL FIELDS IN POST OBJECT
     * @param postDto
     * @return false if any field is null and will cancel the create method!
     */
    public static boolean checkAllFields(PostDTO postDto){
        if(postDto.getTitle() == null){
            System.out.println("error with title");
            return false;
        }
        if(postDto.getTastingNotes() == null){
            System.out.println("error with tastingnotes");
            return false;
        }
//        if(postObject.getRating() == null){
//            System.out.println("error with rating");
//            return false;
//        }
        if(postDto.getImgSrc() == null){
            System.out.println("error with img src");
            return false;
        }
        return true;
    }
}
