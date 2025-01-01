package com.znaji.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private String courtName;
    private LocalDate date;
    private int hour;
    private Player player;
    private SportType sportType;
}
