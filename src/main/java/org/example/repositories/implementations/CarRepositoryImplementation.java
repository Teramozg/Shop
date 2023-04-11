package org.example.repositories.implementations;

import org.example.models.Car;
import org.example.repositories.CarRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRepositoryImplementation implements CarRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/shop";
    private static String user = "postgres";
    private static String password = "Parenek1";

    @Override
    public List<Car> getAllCar() {
        List<Car> listCar = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "SELECT *FROM cars;";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int power = resultSet.getInt("power");
                String vin = resultSet.getString("vin");
                int year = resultSet.getInt("year");
                int weight = resultSet.getInt("weight");
                Car car = new Car(id, brand, model, power, vin, year, weight);
                listCar.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listCar;
    }

    @Override
    public List<Car> getCarByVin(String vinSearch) {
        List<Car> listCar = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM public.cars WHERE vin ='" + vinSearch + "';";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int power = resultSet.getInt("power");
                String vin = resultSet.getString("vin");
                int year = resultSet.getInt("year");
                int weight = resultSet.getInt("weight");
                Car car = new Car(id, brand, model, power, vin, year, weight);
                listCar.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCar;
    }

    public List<Car> getCarById(int idSearch) {
        List<Car> listCar = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM public.cars WHERE id ='" + idSearch + "';";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int power = resultSet.getInt("power");
                String vin = resultSet.getString("vin");
                int year = resultSet.getInt("year");
                int weight = resultSet.getInt("weight");
                Car car = new Car(id, brand, model, power, vin, year, weight);
                listCar.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCar;
    }

    public List<Car> getCarByBrand(String brandSearch) {
        List<Car> listCar = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM public.cars WHERE brand ='" + brandSearch + "';";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int power = resultSet.getInt("power");
                String vin = resultSet.getString("vin");
                int year = resultSet.getInt("year");
                int weight = resultSet.getInt("weight");
                Car car = new Car(id, brand, model, power, vin, year, weight);
                listCar.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCar;
    }

    public List<Car> getCarByYearFromYearSearch(int yearSearch) {
        List<Car> listCar = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "SELECT * FROM public.cars WHERE year ='" + yearSearch + "';";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int power = resultSet.getInt("power");
                String vin = resultSet.getString("vin");
                int year = resultSet.getInt("year");
                int weight = resultSet.getInt("weight");
                if (year >= yearSearch) {
                    Car car = new Car(id, brand, model, power, vin, year, weight);
                    listCar.add(car);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCar;
    }

    public void addCarToBase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название Бренда авто");
        String brand = scanner.next();
        System.out.println("Введите модель авто.");
        String model = scanner.next();
        System.out.println("Введите мощность двигателя.");
        int power = scanner.nextInt();
        System.out.println("Введите номер VIN.");
        String vin = scanner.next();
        System.out.println("Введите год выпуска авто.");
        int year = scanner.nextInt();
        System.out.println("Введите максимальный допустимый вес авто.");
        int weight = scanner.nextInt();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();

            String s = "INSERT INTO public.cars (brand, model, power, vin, year, weight ) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(s);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, power);
            preparedStatement.setString(4, vin);
            preparedStatement.setInt(5, year);
            preparedStatement.setInt(6, weight);

//           String s = "INSERT INTO public.cars(brand, model, power, vin, year, weight) VALUES ('" + brand + "', '" + model + "', '" + power + "', '" + vin + "', '" + year + "', '" + weight + "');";
//           String s = "INSERT INTO public.cars(brand, model, power, vin, year, weight) VALUES ('" + brand + "', '" + model + "', '" + power + "', '" + vin + "', '" + year + "', '" + weight + "');";
//            System.out.println(s);
            preparedStatement.executeUpdate();

//
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Car> ownersListCar(int idSearch) {
        List<Car> listCar = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "SELECT public.cars.id, public.cars.brand, public.cars.model, public.cars.power," +
                    " public.cars.vin, public.cars.year, public.cars.weight, public.cars.owner_id " +
                    "FROM public.cars JOIN public.owners ON public.cars.owner_id=public.owners.id;";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int power = resultSet.getInt("power");
                String vin = resultSet.getString("vin");
                int year = resultSet.getInt("year");
                int weight = resultSet.getInt("weight");
                int owner_id = resultSet.getInt("owner_id");
                if (idSearch==owner_id) {
                    Car car = new Car(id, brand, model, power, vin, year, weight);
                    listCar.add(car);
                } else {

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCar;
    }

    @Override
    public void ownerUpdate(int carId, int ownerId) {
        try {
            Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement();
            String s = "UPDATE public.cars SET  owner_id="+ownerId+" WHERE id="+carId;

           statement.executeUpdate(s);

//
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

public void addOwner(String firstName,String lastName){
    try {
        Connection connection = DriverManager.getConnection(URL, user, password);
        Statement statement = connection.createStatement();
        String s = "INSERT INTO public.owners(first_name, last_name) VALUES ('"+firstName+"','"+lastName+"');";

        statement.executeUpdate(s);

//
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public void sendToRace(int date, int month, int year,  String description ){
    try {
        Connection connection = DriverManager.getConnection(URL, user, password);
        Statement statement = connection.createStatement();
        String s = "INSERT INTO public.race_list(date, description ) VALUES ('"+date+"-"+month+"-"+year+"','"+description+"');";
        statement.executeUpdate(s);



//
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

//todo нарисовать структуру базы данных(прототип базы данных)
    // todo сервис отправки водителя в рейс.
    //todo поковырять html-code.



}
