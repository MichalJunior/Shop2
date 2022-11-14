package pl.camp.it.Shop2.model;

public class Product {
    private final int prize;
    private final int keyProduct;

    public int getPrize() {
        return prize;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private final String name;

    private int quantity;


    public Product(int prize, int keyProduct, int quantity, String name) {
        this.prize = prize;
        this.keyProduct = keyProduct;
        this.quantity = quantity;
        this.name = name;
    }

    public Product(String[] params) {
        this.name = params[0];
        this.prize = Integer.parseInt(params[1]);
        this.keyProduct = Integer.parseInt(params[2]);
        this.quantity = Integer.parseInt(params[3]);

    }

    public int getKeyProduct() {
        return keyProduct;
    }
}
