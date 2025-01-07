package com.znaji.recipes.recipe8;

import com.znaji.exception.CourtNameForbiddenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ReservationControllerExceptionsAdvice {
    @ExceptionHandler(CourtNameForbiddenException.class)
    public ModelAndView courtNameForbiddenExceptionHandler(CourtNameForbiddenException ex) {
        ModelAndView courtNameForbidden = new ModelAndView("courtNameForbidden");
        courtNameForbidden.addObject("courtName", ex.getCourtName());
        return courtNameForbidden;
    }
}
