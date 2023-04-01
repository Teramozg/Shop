package org.example.models;

import java.util.List;

public class Owner {
   private int id;
   private  String firstName;
   private  String lastName;

   private List<Car> listCar;

    public Owner(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Owner(int id, String firstName, String lastName, List<Car> listCar) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.listCar = listCar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getListCar() {
        return listCar;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }
}
