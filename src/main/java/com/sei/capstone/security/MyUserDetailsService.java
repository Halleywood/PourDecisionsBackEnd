package com.sei.capstone.security;


import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.User;
import com.sei.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    /**
     * UserDetailsService requires one read-only method, which finds a User by the unique email and stores in MyUserDetails
     */
    private UserService userService;

    /**
     * Sets the UserService dependency.
     *
     * @param userService the UserService instance to be injected
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Loads a user by the given email and returns UserDetails.
     *
     * @param email the email of the user to load
     * @return the UserDetails of the loaded user
     * @throws com.sei.capstone.exceptions.InformationNotFoundException the user with the given email is not found
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws InformationNotFoundException {
        User user = userService.findUserByEmail(email);
        return new MyUserDetails(user);
    }
}
