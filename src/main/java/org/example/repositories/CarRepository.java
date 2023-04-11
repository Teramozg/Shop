package org.example.repositories;

import org.example.models.Car;

import java.util.List;

public interface CarRepository {
    List<Car> getAllCar();
    List<Car> getCarByVin(String vinSearch);

    List<Car> getCarById(int idSearch);

    List<Car> getCarByBrand(String s);

    List<Car> getCarByYearFromYearSearch(int yearSearch);

    public void addCarToBase();

    List<Car> ownersListCar(int idSearch);

    void ownerUpdate(int carId, int ownerId);

    void addOwner(String firstName,String lastName);
    public void sendToRace(int date, int month, int year, String description );

}
