package pl.camp.it.car.rent.model;

public class Motorcycle extends Vehicle {

    private boolean cart;

    public Motorcycle(String brand, String model, int year, String plate, double price, boolean cart) {
        super(brand, model, year, plate, price);
        this.cart = cart;
    }

    public Motorcycle() {
    }

    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }
}
