package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;

public class GUI {
    public static void showMenu() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicle");
        System.out.println("3. Exit");
    }

    public static void listCars(Car[] cars) {
        for(Car currentCar : cars) {
            System.out.println(currentCar.getBrand() + " " +
                    currentCar.getModel() + " " + currentCar.getPrice() + " " +
                    currentCar.getPlate() + " " + currentCar.isRent());
        }
    }

    public static void listBuses(Bus[] buses) {
        for(Bus currentBus : buses) {
            System.out.println(currentBus.getBrand() + " " +
                    currentBus.getModel() + " " + currentBus.getPrice() + " " +
                    currentBus.getSeats() + " " +
                    currentBus.getPlate() + " " + currentBus.isRent());
        }
    }
}
