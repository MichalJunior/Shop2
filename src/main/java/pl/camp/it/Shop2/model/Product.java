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

    public  int getQuantity() {
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

    public int getKeyProduct() {
        return keyProduct;
    }
}
