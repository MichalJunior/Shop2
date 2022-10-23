package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.model.*;

import java.util.Scanner;

public class GUI {
    public static void showMenu() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicle");
        if(Authenticator.loggedUser.getRole().equals("ADMIN")) {
            System.out.println("3. Add vehicle");
        }

        System.out.println("4. Exit");
    }

    public static void listVehicles(Vehicle[] vehicles) {
        for(Vehicle currentVehicle : vehicles) {
            String result = currentVehicle.getBrand() + " " +
                    currentVehicle.getModel() + " " +
                    currentVehicle.getPrice() + " ";

            if(currentVehicle instanceof Bus) {
                result = result + ((Bus) currentVehicle).getSeats() + " ";
            } else if(currentVehicle instanceof Motorcycle) {
                result = result + ((Motorcycle) currentVehicle).isCart() + " ";
            }

            result = result + currentVehicle.getPlate() + " " +
                    currentVehicle.isRent();
            System.out.println(result);
        }
    }

    public static User readLoginAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }

    public static void addVehicle(VehicleDB vehicleDB) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Car");
        System.out.println("2. Bus");
        System.out.println("3. Motorcycle");
        String type = scanner.nextLine();
        switch (type) {
            case "1":
                Car car = new Car();
                System.out.println("Brand:");
                car.setBrand(scanner.nextLine());
                System.out.println("Model:");
                car.setModel(scanner.nextLine());
                System.out.println("Year:");
                car.setYear(Integer.parseInt(scanner.nextLine()));
                car.setRent(false);
                System.out.println("Plate:");
                car.setPlate(scanner.nextLine());
                System.out.println("Price:");
                car.setPrice(Double.parseDouble(scanner.nextLine()));
                vehicleDB.addVehicle(car);
                System.out.println("Car added !!");
                break;
            case "2":
                Bus bus = new Bus();
                System.out.println("Brand:");
                bus.setBrand(scanner.nextLine());
                System.out.println("Model:");
                bus.setModel(scanner.nextLine());
                System.out.println("Year:");
                bus.setYear(Integer.parseInt(scanner.nextLine()));
                bus.setRent(false);
                System.out.println("Plate:");
                bus.setPlate(scanner.nextLine());
                System.out.println("Price:");
                bus.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Seats:");
                bus.setSeats(Integer.parseInt(scanner.nextLine()));
                vehicleDB.addVehicle(bus);
                System.out.println("Bus added !!");
                break;
            case "3":
                Motorcycle motorcycle = new Motorcycle();
                System.out.println("Brand:");
                motorcycle.setBrand(scanner.nextLine());
                System.out.println("Model:");
                motorcycle.setModel(scanner.nextLine());
                System.out.println("Year:");
                motorcycle.setYear(Integer.parseInt(scanner.nextLine()));
                motorcycle.setRent(false);
                System.out.println("Plate:");
                motorcycle.setPlate(scanner.nextLine());
                System.out.println("Price:");
                motorcycle.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Has cart (y/n):");
                motorcycle.setCart(scanner.nextLine().equals("y"));
                vehicleDB.addVehicle(motorcycle);
                System.out.println("Motorcycle added !!");
                break;
            default:
                System.out.println("Wrong choose !!");
                break;
        }
    }
}
