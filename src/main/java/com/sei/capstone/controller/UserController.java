package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Post;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.repository.WineRepository;
import com.sei.capstone.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserRepository userRepo;
    private UserProfileRepository profileRepo;

    private UserController(UserRepository userRepo, UserProfileRepository profileRepo) {
        this.userRepo = userRepo;
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
    /**
     * GET A USER PROFILE
     * @param userProfileId
     * @return
     */
    @GetMapping("/profile/{userProfileId}")
    public UserProfile getOneProfile(@PathVariable Long userProfileId) {
        Optional<UserProfile> profile = profileRepo.findById(userProfileId);
        if (profile.isPresent()) {
            return profile.get();
        } else {
            throw new InformationNotFoundException("There is no User Profile with id " + userProfileId);
        }
    }

    /**
     * UPDATE A USER PROFILE.
     * @param userProfileId
     * @param profileObject
     * @return
     */
    @PutMapping("/profile/{userProfileId}")
    public UserProfile updateUserProfile(@PathVariable Long userProfileId, @RequestBody UserProfile profileObject) {
        if (getCurrentLoggedInUser().getId() == userProfileId) {
            UserProfile profileToUpdate = getOneProfile(userProfileId);
            if (profileObject.getUserName() != null) {
                profileToUpdate.setUserName(profileObject.getUserName());
            }
            if (profileObject.getTagline() != null) {
                profileToUpdate.setTagline(profileObject.getTagline());
            }
            if (profileObject.getImgSrc() != null) {
                profileToUpdate.setImgSrc(profileObject.getImgSrc());
            }
            profileRepo.save(profileToUpdate);
            return profileToUpdate;
        } else {
            throw new RuntimeException("YOU CANNOT UPDATE ANOTHER USER'S PROFILE");
        }
    }

    @GetMapping("/profile/{userProfileId}/posts")
    public List<Post> getPostsOfAUser(@PathVariable Long userProfileId){
        Optional<UserProfile> checkForProfile = profileRepo.findById(userProfileId);
        if(checkForProfile.isEmpty()){
            throw new InformationNotFoundException("No profile with id of "+ userProfileId+ "exists!");
        }
        else {
            List<Post> profilePosts = checkForProfile.get().getUserPosts();
            if (profilePosts.size() == 0) {
                throw new InformationNotFoundException("The user with profile id of " + userProfileId + " has no posts yet!");
            } else {
                return profilePosts;
            }
        }
    }
}
