package pl.camp.it.Shop2.database;

import pl.camp.it.Shop2.OptionsProvider;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;
import java.util.*;

public class ProductDB {
    private final GUI gui = new GUI();

    private final HashMap<Product, Integer> availableProducts = new HashMap<>();
    private final OptionsProvider optionsProvider = new OptionsProvider();

    public void printListOfAvailableProducts() {
        if (Product.COMPUTER.quantity > 0) {
            availableProducts.put(Product.COMPUTER, Product.COMPUTER.quantity);
        }
        if (Product.MOUSE.quantity > 0) {
            availableProducts.put(Product.MOUSE, Product.MOUSE.quantity);
        }
        if (Product.KEYBOARD.quantity > 0) {
            availableProducts.put(Product.KEYBOARD, Product.KEYBOARD.quantity);
        }
        if (Product.HARDRIVE.quantity > 0) {
            availableProducts.put(Product.HARDRIVE, Product.HARDRIVE.quantity);
        }
        if (Product.MONITOR.quantity > 0) {
            availableProducts.put(Product.MONITOR, Product.MONITOR.quantity);
        }
        if (Product.PENDRIVE.quantity > 0) {
            availableProducts.put(Product.PENDRIVE, Product.PENDRIVE.quantity);
        }
        gui.printAvailableProducts(availableProducts);
        availableProducts.clear();
    }

    public void addProduct() throws IOException {

        switch (optionsProvider.readChar("Insert your choice:")) {
            case '1' -> {
                gui.askUserForQuantity();
                Product.COMPUTER.quantity += optionsProvider.readInt();
                gui.printAddProductToDB(Product.COMPUTER.name());
            }
            case '2' -> {
                gui.askUserForQuantity();
                Product.MOUSE.quantity += optionsProvider.readInt();
                gui.printAddProductToDB(Product.MOUSE.name());
            }
            case '3' -> {
                gui.askUserForQuantity();
                Product.KEYBOARD.quantity += optionsProvider.readInt();
                gui.printAddProductToDB(Product.KEYBOARD.name());
            }
            case '4' -> {
                gui.askUserForQuantity();
                Product.MONITOR.quantity += optionsProvider.readInt();
                gui.printAddProductToDB(Product.MONITOR.name());
            }
            case '5' -> {
                gui.askUserForQuantity();
                Product.HARDRIVE.quantity += optionsProvider.readInt();
                gui.printAddProductToDB(Product.HARDRIVE.name());
            }
            case '6' -> {
                gui.askUserForQuantity();
                Product.PENDRIVE.quantity += optionsProvider.readInt();
                gui.printAddProductToDB(Product.PENDRIVE.name());
            }
            default -> gui.printNothingAdded();
        }
    }

    public void buyProduct() throws IOException {


        switch ((optionsProvider.readChar("Insert your choice:"))) {
            case '1' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= Product.COMPUTER.quantity) {
                    Product.COMPUTER.quantity -= chosenQuantity;
                    gui.printSuccessfullyBought(Product.COMPUTER.name(), chosenQuantity, chosenQuantity * Product.COMPUTER.prize);
                } else gui.unsuccessfullyBought();
            }
            case '2' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= Product.MOUSE.quantity) {
                    Product.MOUSE.quantity -= chosenQuantity;
                    gui.printSuccessfullyBought(Product.MOUSE.name(), chosenQuantity, chosenQuantity * Product.MOUSE.prize);
                } else gui.unsuccessfullyBought();
            }
            case '3' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= Product.KEYBOARD.quantity) {
                    Product.KEYBOARD.quantity -= chosenQuantity;
                    gui.printSuccessfullyBought(Product.KEYBOARD.name(), chosenQuantity, chosenQuantity * Product.KEYBOARD.prize);
                } else gui.unsuccessfullyBought();
            }
            case '4' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= Product.MONITOR.quantity) {
                    Product.MONITOR.quantity -= chosenQuantity;
                    gui.printSuccessfullyBought(Product.MONITOR.name(), chosenQuantity, chosenQuantity * Product.MONITOR.prize);
                } else gui.unsuccessfullyBought();
            }
            case '5' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= Product.HARDRIVE.quantity) {
                    Product.HARDRIVE.quantity -= chosenQuantity;
                    gui.printSuccessfullyBought(Product.HARDRIVE.name(), chosenQuantity, chosenQuantity * Product.HARDRIVE.prize);
                } else gui.unsuccessfullyBought();
            }
            case '6' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= Product.PENDRIVE.quantity) {
                    Product.PENDRIVE.quantity -= chosenQuantity;
                    gui.printSuccessfullyBought(Product.PENDRIVE.name(), chosenQuantity, chosenQuantity * Product.PENDRIVE.prize);
                } else gui.unsuccessfullyBought();
            }

            default -> System.out.println("--Wrong credentials--");

        }
    }

    public enum Product {
        COMPUTER(5000, 123, 3),
        MOUSE(120, 123, 0),
        KEYBOARD(300, 124, 5),
        MONITOR(600, 125, 11111),
        HARDRIVE(800, 126, 0),
        PENDRIVE(30, 127, 10);
        final int prize;
        final int keyProduct;
        int quantity;


        Product(int prize, int keyProduct, int quantity) {
            this.prize = prize;
            this.keyProduct = keyProduct;
            this.quantity = quantity;
        }

    }


}