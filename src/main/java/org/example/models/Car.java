package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String brand;
    private String model;
    private int power;
    private String vin;
    private int year;
    private int weight;
   // private List<Repair> repairList;
}
// todo JDBC(Java Data Base Connection) почитать
