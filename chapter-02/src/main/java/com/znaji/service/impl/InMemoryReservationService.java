package com.znaji.service.impl;

import com.znaji.model.Player;
import com.znaji.model.Reservation;
import com.znaji.model.SportType;
import com.znaji.service.ReservationService;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryReservationService implements ReservationService {
    private static final SportType TENNIS = new SportType(1, "Tennis");
    private static final SportType SOCCER = new SportType(2, "Soccer");
    private final List<Reservation> reservations =
            Collections.synchronizedList(new ArrayList<>());
    public InMemoryReservationService() {
        var roger = new Player("Roger");
        var james = new Player("James");
        var date = LocalDate.of(2022, 10, 18);
        reservations.add(new Reservation("Tennis #1", date, 16, roger, TENNIS));
        reservations.add(new Reservation("Tennis #2", date, 20, james, TENNIS));
    }
    @Override
    public List<Reservation> query(String courtName) {
        return this.reservations.stream()
                .filter( (r) -> StringUtils.startsWithIgnoreCase(r.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
