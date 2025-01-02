package com.znaji.recipe1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        System.out.println("Hello From Welcome");
        model.addAttribute("today", LocalDate.now());
        return "welcome";
    }
}
