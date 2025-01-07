package com.znaji.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ReservationNotFoundException extends RuntimeException{
    private final String courtName;
    private final LocalDate date;
    private final int hour;

}
