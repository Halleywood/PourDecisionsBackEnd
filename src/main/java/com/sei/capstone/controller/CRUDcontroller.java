package com.sei.capstone.controller;

import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/wines")
    public List<Wine> getAllWines(){
        if(wineRepo.findAll().size() > 0){
            return wineRepo.findAll();
        }
        else{
            throw new InformationNotFoundException("This wine list is empty");
        }
    }
}
