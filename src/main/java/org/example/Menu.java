package org.example;

import org.example.models.Car;
import org.example.service.CarService;
import org.example.service.implementations.CarServiceImplementation;

import java.util.List;
import java.util.Scanner;

public class Menu {
    CarService carService = new CarServiceImplementation();

    public void startMenu() {
        while (true) {
            System.out.println();
            System.out.println("Вводите 1 если нужно вывести инфо всех авто.");
            System.out.println("Вводите 2 если нужно найти авто по VIN ");
            System.out.println("Вводите 3 если нужно найти авто по ID ");
            System.out.println("Вводите 4 если нужно найти авто по Brand ");
            System.out.println("Вводите 5 если нужно найти авто по Year ");
            System.out.println("Введите 6, если хотите добавить авто в базу данных.");
            System.out.println("Введите 7, если нужно получить инфо об авто по ИД владельца.");

            Scanner scan = new Scanner(System.in);
            int action = 0;
            try {
                action = scan.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (action == 1) {
                for (Car car : carService.getAllCar()) {   //объект, а потом список, покоторому проходимся
                    System.out.println(car);

                }


            } else if (action == 2) {
                System.out.println("Введите Vin");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                for (Car car : carService.getCarByVin(s)) {   //объект, а потом список, покоторому проходимся
                    System.out.println(car);

                }


            } else if (action == 3) {
                System.out.println("Введите Id");

                Scanner scanner = new Scanner(System.in);
                int idSearch = scanner.nextInt();
                for (Car car : carService.getCarById(idSearch)) {   //объект, а потом список, покоторому проходимся
                    System.out.println(car);

                }
            } else if (action == 4) {
                System.out.println("Введите Brand");
                Scanner scanner = new Scanner(System.in);
                String brandSearch = scanner.next();
                for (Car car : carService.getCarByBrand(brandSearch)) {   //объект, а потом список, покоторому проходимся
                    System.out.println(car);

                }
            } else if (action == 5) {
                System.out.println("Введите Year");
                Scanner scanner = new Scanner(System.in);
                int yearSearch = scanner.nextInt();
                for (Car car : carService.getCarByYearFromYearSearch(yearSearch)) {   //объект, а потом список, покоторому проходимся
                    System.out.println(car);

                }
            } else if (action == 6) {
                carService.addCarToBase();

            } else if (action == 7) {
                System.out.println("Введите номер Ид владельца для поиска его авто.");
                Scanner scanner = new Scanner(System.in);
                int idSearch = scanner.nextInt();
                for (Car car : carService.ownersListCar(idSearch)) {   //объект, а потом список, покоторому проходимся
                    System.out.println(car);

                }
            }
        }
    }
}