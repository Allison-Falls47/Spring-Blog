package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class UsersController {

    @GetMapping("/")
    @ResponseBody
    public String helloFromSpring(){
        return "This is the landing page!";
    }

}
