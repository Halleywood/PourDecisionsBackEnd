package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.repository.WineRepository;
import com.sei.capstone.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CRUDcontroller {

    @Autowired
    private UserRepository userRepo;
    private WineRepository wineRepo;

    private CRUDcontroller(UserRepository userRepo, WineRepository wineRepo){
        this.userRepo = userRepo;
        this.wineRepo = wineRepo;
    }


    /**
     * Retrives the current logged-in user.
     *
     * @return the User instance representing the current logged-in user.
     */
    public static UserProfile getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser().getUserProfile();
    }


    @GetMapping("/wines")
    public List<Wine> getAllWines(){
        if(wineRepo.findAll().size() > 0){
            return wineRepo.findAll();
        }
        else{
            throw new InformationNotFoundException("This wine list is empty");
        }
    }

    @GetMapping(path="/wine/{wineId}")
    public Wine getOneWine(@PathVariable Long wineId){
        Optional<Wine> wine = wineRepo.findById(wineId);
        if(wine.isEmpty()){
            throw new InformationNotFoundException("No wine with id of "+ wineId + "exists! Please check your search and try again");
        }
        else{
            return wine.get();
        }
    }


}
