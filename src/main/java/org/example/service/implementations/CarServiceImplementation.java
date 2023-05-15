package org.example.service.implementations;

import org.example.models.Car;
import org.example.models.RaceList;
import org.example.repositories.CarRepository;
import org.example.repositories.implementations.CarRepositoryImplementation;
import org.example.service.CarService;

import java.time.LocalDate;
import java.util.List;

public class CarServiceImplementation implements CarService {
    CarRepository carRepository = new CarRepositoryImplementation();

    @Override
    public List<Car> getAllCar() {

        return carRepository.getAllCar();
    }

    @Override
    public List<Car> getCarByVin(String vinSearch) {
        return carRepository.getCarByVin(vinSearch);
    }

    @Override
    public List<Car> getCarById(int idSearch) {
        return carRepository.getCarById(idSearch);
    }

    @Override
    public List<Car> getCarByBrand(String s) {
        return carRepository.getCarByBrand(s);
    }

    @Override
    public List<Car> getCarByYear(int year) {
        return null;
    }

    @Override
    public List<Car> getCarByYearFromYearSearch(int yearSearch) {
        return carRepository.getCarByYearFromYearSearch(yearSearch);
    }

    @Override
    public void addCarToBase() {
        carRepository.addCarToBase();
    }

    @Override
    public List<Car> ownersListCar(int idSearch) {
        return carRepository.ownersListCar(idSearch);
    }

    @Override
    public void ownerUpdate(int carId, int ownerId) {
        carRepository.ownerUpdate(carId,ownerId);
    }
    public void addOwner(String firstName,String lastName){
        carRepository.addOwner(firstName,lastName);
    }

    @Override
    public void sendToRace(LocalDate date, String description, int carsAndDriversId) {
        carRepository.sendToRace(date, description, carsAndDriversId);
    }

    @Override
    public int addCarsDrivers(int carId, int driversId) {
        return carRepository.addCarsDrivers(carId,driversId);


    }

    @Override
    public List<RaceList> raceList(int searchId) {
        return carRepository.raceList(searchId);
    }
}
