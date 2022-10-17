package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;

public class VehicleDB {
    private Car[] cars = new Car[5];
    private Bus[] buses = new Bus[2];

    public VehicleDB() {
        this.cars[0] = new Car("Audi", "A3",
                2005, "KR11", 300.00);
        this.cars[1] = new Car("BMW", "3",
                2006, "KR22", 250.00);
        this.cars[2] = new Car("Toyota", "Corolla",
                2010, "KR33", 200.00);
        this.cars[3] = new Car("Mercedes", "C",
                2020, "KR44", 500.00);
        this.cars[4] = new Car("Kia", "Ceed",
                2011, "KR55", 300.00);

        this.buses[0] = new Bus("Solaris", "2000",
                2010, "KR66", 500.00, 52);
        this.buses[1] = new Bus("Solaris", "3000",
                2011, "KR77", 550.00, 62);
    }

    public boolean rentVehicle(String plate) {
        for(Car currentCar : this.cars) {
            if(currentCar.getPlate().equals(plate) && !currentCar.isRent()) {
                currentCar.setRent(true);
                return true;
            }
        }

        for(Bus currentBus : this.buses) {
            if(currentBus.getPlate().equals(plate) && !currentBus.isRent()) {
                currentBus.setRent(true);
                return true;
            }
        }

        return false;
    }

    public void addCar(Car car) {
        Car[] newCars = new Car[this.cars.length + 1];
        for(int i = 0; i < this.cars.length; i++) {
            newCars[i] = this.cars[i];
        }
        newCars[newCars.length - 1] = car;
        this.cars = newCars;
    }

    public void addBus(Bus bus) {
        Bus[] newBuses = new Bus[this.buses.length + 1];
        for(int i = 0; i < this.buses.length; i++) {
            newBuses[i] = this.buses[i];
        }
        newBuses[newBuses.length - 1] = bus;
        this.buses = newBuses;
    }

    public Car[] getCars() {
        return cars;
    }

    public Bus[] getBuses() {
        return buses;
    }
}
