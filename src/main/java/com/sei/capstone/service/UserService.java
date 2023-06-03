package com.sei.capstone.service;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.exceptions.UserExistsException;
import com.sei.capstone.model.Post;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtils jwUtils;
    private AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;


    @Autowired
    public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager, @Lazy MyUserDetails myUserDetails ){
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
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
     * CREATE USER
     * @param userObject the User object containing email and password.
     *        creates an instance of User and instance of UserProfile
     * @return
     * @throws InformationNotFoundException if a user with the provided email already exists.
     */
    public ResponseEntity<?> registerUser(User userObject){
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

    /**
     * LOGIN USER
     * @param loginRequest
     * @return Response Entity, creates JWT for header for all protected endpoints.
     */
    public ResponseEntity<?> login(LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final String JWT = jwUtils.generateJwtToken(myUserDetails);
            return ResponseEntity.ok(new LoginResponse(JWT));
        } catch(Exception e){
            return ResponseEntity.ok(new LoginResponse("Error: username or password is incorrect"));
        }
    }

    public User getCurrentUser(){
        Optional<User> user = userRepository.findById(getCurrentLoggedInUser().getId());
        if (user.isPresent()) {
            return user.get();
        } else throw new InformationNotFoundException("User with Id " + getCurrentLoggedInUser().getId() + " does not exist.");
    }

    /**
     * Finds a user by their email.
     * @param email the email of the user to find
     * @return the User object corresponding to the provided email
     */
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public UserProfile getOneProfile(Long userProfileId){
        Optional<UserProfile> profile = userProfileRepository.findById(userProfileId);
        if (profile.isPresent()) {
            return profile.get();
        } else {
            throw new InformationNotFoundException("There is no User Profile with id " + userProfileId);
        }
    }

    public UserProfile updateUserProfile(Long userProfileId, UserProfile profileObject){
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
            userProfileRepository.save(profileToUpdate);
            return profileToUpdate;
        } else {
            throw new RuntimeException("YOU CANNOT UPDATE ANOTHER USER'S PROFILE");
        }
    }

    public List<Post> getPostsOfUser(Long userProfileId){
        Optional<UserProfile> checkForProfile = userProfileRepository.findById(userProfileId);
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

    public List<Post> getAllYourPosts(){
        return getCurrentLoggedInUser().getUserPosts();
    }
}
