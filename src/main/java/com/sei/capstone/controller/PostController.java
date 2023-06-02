package com.sei.capstone.controller;

import com.sei.capstone.repository.PostRepository;
import com.sei.capstone.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepo;
    private UserProfileRepository userProfileRepo;


    public PostController(PostRepository postRepo, UserProfileRepository userProfileRepo ){
        this.postRepo = postRepo;
        this.userProfileRepo = userProfileRepo;
    }


    //GET ALL POSTS FOR A USER
    //GET ALL POSTS FOR A WINE
    //CREATE POST
    //UPDATE POST
    //DELETE POST
}
