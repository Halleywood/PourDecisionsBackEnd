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
     * @return the UserProfile instance representing the current logged-in user.
     */
    public static UserProfile getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser().getUserProfile();
    }

    /**
     * @param wineId
     * @return list of Posts with corresponding wine ID
     */
    public List<Post> getAllPostsForWine(Long wineId){
        return postRepo.findAllByWineId(wineId);
    }

    /**
     * @param wineId
     * @param postDto
     * @return First ensures the Wine exists...if wine is present, runs PostDTO through custom method that makes sure no fields are null.
     * if custom method returns False indicating a field is missing information, throws exception to indicate to user some of the fields are missing values.
     *  if returns true, instantiates new Post object, sets fields, then sets User by current logged in user and sets wineId that was passed in path variable.
     *  Sets the post to user's list of posts.
     *  Sets the post to wines list of posts.
     */
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

                postRepo.save(newPost);

                List<Post> userPosts = getCurrentLoggedInUser().getUserPosts();
                userPosts.add(newPost);
                getCurrentLoggedInUser().setUserPosts(userPosts);

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

    /**
     * @param postId
     * @return Gets a Post with corresponding ID
     */
    public Post getOnePost(Long postId){
        Optional<Post> post = postRepo.findById(postId);
        if(post.isPresent()){
            return post.get();
        }
        else{
            throw new InformationNotFoundException("No post with this id exists!");
        }
    }

    /**
     * @param postId
     * @param postObject
     * @return uses getOnePost method above to retrieve post and error handling.  If any of the fields from the postObject are null, it does not set the fields. If they are not null, saves the postObject field value to the currentPost.
     * Resaves the post to the database.
     * @throws Exception if the user logged in is not the user who created post.
     */
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

    /**
     * @param postId
     * @return uses getOnePost method above to retrieve post and error handling. Returns 204 no content indicating the content no longer exists. And custom message indicating user post has been deleted successfully.
     * @throws Exception if logged in user is not the same as user who created post.
     */
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
        if(postDto.getImgSrc() == null){
            System.out.println("error with img src");
            return false;
        }
        return true;
    }
}
