package pl.camp.it.Shop2.model;

public class Keyboard extends Product{

    public Keyboard(int prize, int keyProduct, int quantity, String name) {
        super(prize, keyProduct, quantity, name);
    }

    public Keyboard(String[] params) {
        super(params);
    }
}
