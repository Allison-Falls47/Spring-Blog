package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller

public class PostController {
    @GetMapping( "/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping( "/posts/{id}")
    @ResponseBody
    public String showSinglePost(@PathVariable int id){
        return "view an individual post" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showPostForm(){
        return "view form for creating a new post";
    }

    @PostMapping( "/posts/create")
    @ResponseBody
    public String createPosts(){
        return "create a new post";
    }

}
