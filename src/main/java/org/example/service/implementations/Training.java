package org.example.service.implementations;

import javafx.scene.effect.SepiaTone;
import org.example.models.Car;
import org.example.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Training {
    public static void main(String[] args) {
        CarService carService=new CarServiceImplementation();
        List<Car> allCar=carService.getAllCar();
        List<Car> collect = allCar
                .stream()
                .filter(car1 -> car1.getYear() > 2013)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
        Set<String> collect1 = allCar
                .stream()
                .map(car -> car.getBrand().substring(0, 1).toUpperCase()+car.getBrand().substring(1))
                .collect(Collectors.toSet());                   // todo HTTP протокол. get(select), post(create), put(insert),delete,
        collect1.forEach(el-> System.out.println(el));          // todo oсновы Spring, коллекции, мап.сет., стримы.
                                                                // todo реализовать вставку в середину linkedList;


    }

}
