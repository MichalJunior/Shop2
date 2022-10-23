package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

import java.util.Scanner;

public class Engine {

    public static void start() {
        final VehicleDB vehicleDB = new VehicleDB();
        final UserDB userDB = new UserDB();
        boolean isWorking = Authenticator.authenticate(userDB);
        final Scanner scanner = new Scanner(System.in);

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
                    if(Authenticator.loggedUser.getRole() == User.Role.ADMIN) {
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
