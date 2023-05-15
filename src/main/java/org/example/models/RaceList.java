package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RaceList {
private int id;
private int carId;
private int driverId;
private LocalDate date;
private String description;
private int carsAndDriversId;

    public RaceList(int id, int carId, int driverId, LocalDate date, String description) {

    }
}
