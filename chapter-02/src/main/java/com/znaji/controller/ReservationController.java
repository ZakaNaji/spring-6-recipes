package com.znaji.controller;

import com.znaji.exception.CourtNameForbiddenException;
import com.znaji.exception.ReservationNotFoundException;
import com.znaji.model.Reservation;
import com.znaji.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public void setUpForm() {

    }

    @PostMapping
    public String submitForm(@RequestParam("courtName") String courtName, Model model) {
        var reservations = Collections.<Reservation>emptyList();
        if (courtName != null) {
            if (reservationService.getForbiddenQueriesList().contains(courtName)) {
                throw new CourtNameForbiddenException(courtName);
            }
            reservations = reservationService.query(courtName);
        }
        if (CollectionUtils.isEmpty(reservations)) {
            throw new ReservationNotFoundException(courtName, LocalDate.now(), LocalTime.now().getHour());
        }
        model.addAttribute("reservations", reservations);
        return "reservation";
    }
}
