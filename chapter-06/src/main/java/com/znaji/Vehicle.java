package com.znaji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String vehicleNo;
    private String color;
    private int wheel;
    private int seat;
}
