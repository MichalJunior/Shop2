package pl.camp.it.car.rent;

import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.gui.GUI;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        VehicleDB vehicleDB = new VehicleDB();
        Scanner scanner = new Scanner(System.in);

        //????

        boolean isWorking = true;
        while(isWorking) {
            GUI.showMenu();

            switch(scanner.nextLine()) {
                case "1":
                    GUI.listCars(vehicleDB.getCars());
                    GUI.listBuses(vehicleDB.getBuses());
                    break;
                case "2":
                    System.out.println("Plate:");
                    if(vehicleDB.rentVehicle(scanner.nextLine())) {
                        System.out.println("You have rent this car !!!");
                    } else {
                        System.out.println("Rent error !!");
                    }
                    break;
                case "3":
                    isWorking = false;
                    break;

                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
