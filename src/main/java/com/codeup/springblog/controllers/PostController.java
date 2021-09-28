package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping( "/posts")
    public String showPosts(Model model){

        List<Post> allPosts = postDao.findAll();


        model.addAttribute("posts", allPosts);
        return "post/index";
    }

    @GetMapping( "/posts/{id}")
    public String showSinglePost(@PathVariable long id, Model model){

        Post post = postDao.getById(id);
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

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title,
                             @RequestParam(name = "body") String body) {

        User owner = userDao
        Post postToAdd = new Post(title, body, owner);
        postDao.save(postToAdd);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditPostForm(@PathVariable long id, Model model){
        Post postToEdit = postDao.getById(id);
        model.addAttribute("id", postToEdit.getId());
        return "post/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
        @RequestParam(name = "body") String body,
@RequestParam(name = "owner") User owner
        ){
            Post editedPost = new Post(id, title, body, owner);

            postDao.save(editedPost);

            return "redirect:/posts";

        }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(
            @PathVariable long id
    ){
        Post postToDelete = postDao.getById(id);
        postDao.delete(postToDelete);

        return "redirect:/posts";

    }


}
