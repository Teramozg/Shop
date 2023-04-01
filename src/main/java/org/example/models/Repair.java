package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Repair {
    private int id;
    private String description;
    private double price;
    private LocalDate date;
    private String stationName;
}
