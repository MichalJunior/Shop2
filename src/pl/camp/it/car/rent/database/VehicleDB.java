package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.Vehicle;

public class VehicleDB {
    private Vehicle[] vehicles = new Vehicle[8];

    public VehicleDB() {
        this.vehicles[0] = new Car("Audi", "A3",
                2005, "KR11", 300.00);
        this.vehicles[1] = new Car("BMW", "3",
                2006, "KR22", 250.00);
        this.vehicles[2] = new Car("Toyota", "Corolla",
                2010, "KR33", 200.00);
        this.vehicles[3] = new Car("Mercedes", "C",
                2020, "KR44", 500.00);
        this.vehicles[4] = new Car("Kia", "Ceed",
                2011, "KR55", 300.00);

        this.vehicles[5] = new Bus("Solaris", "2000",
                2010, "KR66", 500.00, 52);
        this.vehicles[6] = new Bus("Solaris", "3000",
                2011, "KR77", 550.00, 62);

        this.vehicles[7] = new Motorcycle("Suzuki", "5000",
                2016, "KR88", 400.00, true);
    }

    public boolean rentVehicle(String plate) {
        for(Vehicle currentVehicle : this.vehicles) {
            if(currentVehicle.getPlate().equals(plate) && !currentVehicle.isRent()) {
                currentVehicle.setRent(true);
                return true;
            }
        }

        return false;
    }

    public void addVehicle(Vehicle vehicle) {
        Vehicle[] newVehicles = new Vehicle[this.vehicles.length + 1];
        for(int i = 0; i < this.vehicles.length; i++) {
            newVehicles[i] = this.vehicles[i];
        }
        newVehicles[newVehicles.length - 1] = vehicle;
        this.vehicles = newVehicles;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
