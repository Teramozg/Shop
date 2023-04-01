package org.example.service;

import org.example.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    List<Car> getCarByVin(String vinSearch);
    List<Car> getCarById(int idSearch);

    List<Car> getCarByBrand(String s);

    List<Car> getCarByYear(int year);

    List<Car> getCarByYearFromYearSearch(int yearSearch);

    public void addCarToBase();

    List<Car> ownersListCar(int idSearch);
}
