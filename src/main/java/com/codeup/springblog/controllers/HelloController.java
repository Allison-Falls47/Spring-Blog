package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class HelloController {
    @GetMapping("/test")
    @ResponseBody
    public String helloFromSpring(){
        return "Hello from the world of Spring.";
    }

    @GetMapping("/helloWorld/{username}")
    @ResponseBody
    public String helloWorld(@PathVariable String username){
        return "Hello " + username + "!";
    }

    @GetMapping("/birthday/{username}/{age}")
    @ResponseBody
    public String helloWorld(
            @PathVariable String username,
            @PathVariable int age
    ){
        return "Happy Birthday, " + username + "you are " + age + " years old.";
    }

    @GetMapping("/random/number")
    @ResponseBody
    public int RandomNumber(){
            Random r = new Random();
            int low = 1;
            int high = 100;
            return r.nextInt(high-low) + low;
    }

    @GetMapping("/weather")
    public String viewWeather(Model model){
        model.addAttribute("temp", "98F");
        return "WeatherPage";
    }

}
