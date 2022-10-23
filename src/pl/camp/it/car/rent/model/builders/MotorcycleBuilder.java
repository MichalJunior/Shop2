package pl.camp.it.car.rent.model.builders;

import pl.camp.it.car.rent.model.Motorcycle;

public class MotorcycleBuilder {
    private Motorcycle motorcycle = new Motorcycle();

    public MotorcycleBuilder() {
        this.motorcycle.setRent(false);
    }

    public MotorcycleBuilder brand(String brand) {
        this.motorcycle.setBrand(brand);
        return this;
    }

    public MotorcycleBuilder model(String model) {
        this.motorcycle.setModel(model);
        return this;
    }

    public MotorcycleBuilder year(int year) {
        this.motorcycle.setYear(year);
        return this;
    }

    public MotorcycleBuilder plate(String plate) {
        this.motorcycle.setPlate(plate);
        return this;
    }

    public MotorcycleBuilder price(double price) {
        this.motorcycle.setPrice(price);
        return this;
    }

    public MotorcycleBuilder cart(boolean cart) {
        this.motorcycle.setCart(cart);
        return this;
    }

    public Motorcycle build() {
        return this.motorcycle;
    }
}
