package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller

public class PostController {
    @GetMapping( "/posts")
    public String showPosts(Model model){

        List<Post> allPosts = new ArrayList<>();

        allPosts.add(new Post("post!", "post1 body"));
        allPosts.add(new Post("post@", "post2 body"));

        model.addAttribute("posts", allPosts);
        return "post/index";
    }

    @GetMapping( "/posts/{id}")
    public String showSinglePost(@PathVariable int id, Model model){

        Post post = new Post("Fun title", "fun body");
        model.addAttribute("postId", id);
        model.addAttribute("post", post);
        return "post/show";
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
