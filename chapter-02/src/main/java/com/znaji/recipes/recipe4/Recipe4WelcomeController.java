package com.znaji.recipes.recipe4;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/recipe4")
public class Recipe4WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("locale", LocaleContextHolder.getLocale().getCountry());
        model.addAttribute("today", LocalDateTime.now());
        return "welcome";
    }
}
