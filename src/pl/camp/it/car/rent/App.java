package pl.camp.it.car.rent;

import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.gui.GUI;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        VehicleDB vehicleDB = new VehicleDB();
        UserDB userDB = new UserDB();
        boolean isWorking = Authenticator.authenticate(userDB);
        Scanner scanner = new Scanner(System.in);

        while(isWorking) {
            GUI.showMenu();

            switch(scanner.nextLine()) {
                case "1":
                    GUI.listVehicles(vehicleDB.getVehicles());
                    break;
                case "2":
                    System.out.println("Plate:");
                    if(vehicleDB.rentVehicle(scanner.nextLine())) {
                        System.out.println("You have rent this vehicle !!!");
                    } else {
                        System.out.println("Rent error !!");
                    }
                    break;
                case "4":
                    scanner.close();
                    isWorking = false;
                    break;
                case "3":
                    if(Authenticator.loggedUser.getRole().equals("ADMIN")) {
                        GUI.addVehicle(vehicleDB);
                        break;
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
