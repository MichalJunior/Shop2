package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.gui.GUI;

import java.util.*;

public class ProductDB {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
   public HashMap<Product, Integer> availableProducts = new HashMap<>();

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
            availableProducts.put(Product.HARDRIVE, Product.HARDRIVE.quantity);
        }
        if (Product.PENDRIVE.quantity > 0) {
            availableProducts.put(Product.PENDRIVE, Product.PENDRIVE.quantity);
        }
        GUI.printAvailableProducts(availableProducts);
        availableProducts.clear();
    }

    public void addProduct() {

        switch (scanner.nextInt()) {
            case 1 :{
                GUI.askUserForQuantity();
                Product.COMPUTER.quantity += scanner2.nextInt();
                GUI.printAddProductToDB(Product.COMPUTER.name());
                break;
            }
            case 2 : {
                GUI.askUserForQuantity();
                Product.MOUSE.quantity += scanner2.nextInt();
                GUI.printAddProductToDB(Product.MOUSE.name());
                break;
            }
            case 3 : {
                GUI.askUserForQuantity();
                Product.KEYBOARD.quantity += scanner2.nextInt();
                GUI.printAddProductToDB(Product.KEYBOARD.name());
                break;
            }
            case 4 : {
                GUI.askUserForQuantity();
                Product.MONITOR.quantity += scanner2.nextInt();
                GUI.printAddProductToDB(Product.MONITOR.name());
                break;

            }
            case 5 : {
                GUI.askUserForQuantity();
                Product.HARDRIVE.quantity += scanner2.nextInt();
                GUI.printAddProductToDB(Product.HARDRIVE.name());
                break;
            }
            case 6 : {
                GUI.askUserForQuantity();
                Product.PENDRIVE.quantity += scanner2.nextInt();
                GUI.printAddProductToDB(Product.PENDRIVE.name());
                break;
            }
            default : GUI.printNothingAdded();
        }
    }

    public void buyProduct() {
        Scanner scanner2 = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 1 : {
                GUI.askUserForQuantity();
                int chosenQuantity = scanner2.nextInt();
                if (chosenQuantity <= Product.COMPUTER.quantity) {
                    Product.COMPUTER.quantity -= chosenQuantity;
                    GUI.printSuccessfullyBought(Product.COMPUTER.name(), chosenQuantity, chosenQuantity * Product.COMPUTER.prize);
                } else GUI.unsuccessfullyBought();
                break;
            }
            case 2 : {
                GUI.askUserForQuantity();
                int chosenQuantity = scanner2.nextInt();
                if (chosenQuantity <= Product.MOUSE.quantity) {
                    Product.MOUSE.quantity -= chosenQuantity;
                    GUI.printSuccessfullyBought(Product.MOUSE.name(), chosenQuantity, chosenQuantity * Product.MOUSE.prize);
                } else GUI.unsuccessfullyBought();
                break;
            }
            case 3 : {
                GUI.askUserForQuantity();
                int chosenQuantity = scanner2.nextInt();
                if (chosenQuantity <= Product.KEYBOARD.quantity) {
                    Product.KEYBOARD.quantity -= chosenQuantity;
                    GUI.printSuccessfullyBought(Product.KEYBOARD.name(), chosenQuantity, chosenQuantity * Product.KEYBOARD.prize);
                } else GUI.unsuccessfullyBought();
                break;
            }
            case 4 : {
                GUI.askUserForQuantity();
                int chosenQuantity = scanner2.nextInt();
                if (chosenQuantity <= Product.MONITOR.quantity) {
                    Product.MONITOR.quantity -= chosenQuantity;
                    GUI.printSuccessfullyBought(Product.MONITOR.name(), chosenQuantity, chosenQuantity * Product.MONITOR.prize);
                } else GUI.unsuccessfullyBought();
                break;
            }
            case 5 : {
                GUI.askUserForQuantity();
                int chosenQuantity = scanner2.nextInt();
                if (chosenQuantity <= Product.HARDRIVE.quantity) {
                    Product.HARDRIVE.quantity -= chosenQuantity;
                    GUI.printSuccessfullyBought(Product.HARDRIVE.name(), chosenQuantity, chosenQuantity * Product.HARDRIVE.prize);
                } else GUI.unsuccessfullyBought();
                break;
            }
            case 6 : {
                GUI.askUserForQuantity();
                int chosenQuantity = scanner2.nextInt();
                if (chosenQuantity <= Product.PENDRIVE.quantity) {
                    Product.PENDRIVE.quantity -= chosenQuantity;
                    GUI.printSuccessfullyBought(Product.PENDRIVE.name(), chosenQuantity, chosenQuantity * Product.PENDRIVE.prize);
                } else GUI.unsuccessfullyBought();
                break;

            }

            default : System.out.println("--Wrong credentials--");
                break;
        }
    }

    public enum Product {
        COMPUTER(5000, 123, 3),
        MOUSE(120, 123, 0),
        KEYBOARD(300, 124, 5),
        MONITOR(600, 125, 0),
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