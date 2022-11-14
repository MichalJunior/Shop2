package pl.camp.it.Shop2.model;

public class Pendrive extends  Product {

    public Pendrive(int prize, int keyProduct, int quantity, String name) {
        super(prize, keyProduct, quantity, name);
    }

    public Pendrive(String[] params) {
        super(params);
    }
}
