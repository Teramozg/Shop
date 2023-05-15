package org.example.repositories;

import org.example.models.Car;
import org.example.models.RaceList;

import java.time.LocalDate;
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
    public void sendToRace(LocalDate date, String description,int carsAndDriversId );
    public int addCarsDrivers(int carId, int driversId);

    public List<RaceList> raceList(int searchId);
}
