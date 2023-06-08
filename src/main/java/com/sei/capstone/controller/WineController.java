package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.repository.WineRepository;
import com.sei.capstone.security.MyUserDetails;
import com.sei.capstone.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WineController {

    @Autowired
    private UserRepository userRepo;
    private WineRepository wineRepo;
    private WineService wineService;

    private WineController(WineService wineService, UserRepository userRepo, WineRepository wineRepo) {
        this.wineService = wineService;
        this.userRepo = userRepo;
        this.wineRepo = wineRepo;
    }

    /**
     * GET ALL WINES
     * @return List<Wine>
     */
    @GetMapping("/wines")
    public List<Wine> getAllWines() {
        return wineService.getAllWines();
    }

    /**
     * GET A SINGLE WINE BY ID.
     * @param wineId
     * @return Wine
     */
    @GetMapping(path = "/wine/{wineId}")
    public Wine getOneWine(@PathVariable Long wineId) {
        return wineService.getOneWine(wineId);
    }



}
