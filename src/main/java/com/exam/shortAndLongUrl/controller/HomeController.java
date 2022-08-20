package com.exam.shortAndLongUrl.controller;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
public class HomeController {

    private Map<String, Object> mapObj;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("message",   "Welcome to Simple Solution home page!");
//        return "index";
//    }

    @GetMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView mv = new ModelAndView("/WEB-INF/views/home.jsp");
        mv.addObject("ok", "OKK");
        return mv;
    }

    @PostMapping("/longToShortUrl")
    public Map<String , Object> LongToShortUrl(@RequestParam String longUrl) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(longUrl);
        return map;
    }

    @PostMapping("/shortToLongUrl/{shortUrl}")
    public Map<String , Object> shortToLongUrl(@PathVariable String shortUrl) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(shortUrl);
        return map;
    }
}
