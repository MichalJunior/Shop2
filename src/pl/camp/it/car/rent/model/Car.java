package pl.camp.it.car.rent.model;

public class Car {
    private String brand;
    private String model;
    private int year;
    private boolean rent;
    private String plate;
    private double price;

    public Car(String brand, String model, int year,
               String plate, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rent = false;
        this.plate = plate;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isRent() {
        return rent;
    }

    public String getPlate() {
        return plate;
    }

    public double getPrice() {
        return price;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
