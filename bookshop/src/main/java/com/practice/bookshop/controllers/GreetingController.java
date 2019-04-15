package com.practice.bookshop.controllers;

import com.practice.bookshop.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute("greeting") Greeting greeting) {
        return "result";
    }



    @GetMapping("/result")
    public String resultPage(Model model){
        return "";
    }
}

