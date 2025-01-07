package com.znaji.service;

import com.znaji.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);

    List<String> getForbiddenQueriesList();
}
