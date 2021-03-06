//package com.codeup.springblog.controllers;
//
//import com.codeup.springblog.models.Ad;
//import com.codeup.springblog.models.User;
//import com.codeup.springblog.repos.AdRepository;
//import com.codeup.springblog.repos.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class AdController {
//
//    @Autowired
//    private final AdRepository adDao;
//
//    @Autowired
//    private UserRepository userDao;
//
//    public AdController(AdRepository adDao) {
//        this.adDao = adDao;
//    }
//
//    @GetMapping("/ads")
//    public String showAds(Model model) {
//
//        List<Ad> adsToShow = adDao.findAll();
//
//        model.addAttribute("ads", adsToShow);
//        return "ad/index";
//    }
//
//    @GetMapping("/ads/{id}")
//    public String showOneAd(@PathVariable Long id, Model model) {
//
//        Ad adToShow = adDao.getById(id);
//        model.addAttribute("ad", adToShow);
//
//        return "ad/show";
//    }
//
//    @GetMapping("/ads/create")
//    public String showCreateAdForm() {
//
//        return "ad/create";
//    }
//
//    @PostMapping("/ads/create")
//    public String createAd(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description
//    ) {
//
//        User hardCodedUser = userDao.getById(1L);
//
//        Ad adToSubmitToDB = new Ad(title,description);
//
//        adDao.save(adToSubmitToDB);
//
//        return "redirect:/ads";
//    }
//
//}