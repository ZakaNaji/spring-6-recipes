package com.znaji.recipes.recipe1.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.time.LocalDate;

public class TestController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView welcome = new ModelAndView("welcome");
        welcome.addObject("today", LocalDate.now());
        return welcome;
    }
}
