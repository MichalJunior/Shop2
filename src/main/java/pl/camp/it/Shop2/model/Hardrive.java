package pl.camp.it.Shop2.model;

public class Hardrive extends  Product {

    public Hardrive(int prize, int keyProduct, int quantity, String name) {
        super(prize, keyProduct, quantity, name);
    }

    public Hardrive(String[] params) {
        super(params);
    }
}
