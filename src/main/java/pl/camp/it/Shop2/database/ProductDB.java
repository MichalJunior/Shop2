package pl.camp.it.Shop2.database;

import pl.camp.it.Shop2.OptionsProvider;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.*;

import java.io.IOException;
import java.util.*;

public class ProductDB {
    private final GUI gui = new GUI();
    private final OptionsProvider optionsProvider = new OptionsProvider();


    private static final List<Product> shopProductList = new ArrayList<>();

    List<String> availableProducts = new ArrayList<>();


    public static List<Product> getShopProductList() {
        return shopProductList;
    }

    //   Product computer = new Computer(5000, 122, 3, "computer");
//     Product monitor = new Monitor(300, 123, 6, "monitor");
//     Product mouse = new Mouse(300, 124, 50, "mouse");
//     Product keyboard = new Keyboard(600, 125, 11332, "keyboard");
//      Product hardrive = new Hardrive(800, 126, 4, "hardrive");
//      Product pendrive = new Pendrive(30, 127, 10, "pendrive");
//
//       public void listOfProducts() {
//        shopProductList.add(computer);
//        shopProductList.add(monitor);
//        shopProductList.add(mouse);
//        shopProductList.add(keyboard);
//        shopProductList.add(hardrive);
//        shopProductList.add(pendrive);
//       }

    public void printListOfAvailableProducts() {


        for (Product productOnList : shopProductList)
            if (productOnList.getQuantity() > 0) {
                availableProducts.add(productOnList.getName().toUpperCase() + " " + productOnList.getQuantity());
            }
        gui.printAvailableProducts(availableProducts);
        availableProducts.clear();
    }

    public void addProduct() throws IOException {

        switch (optionsProvider.readChar("Insert your choice:")) {
            case '1' -> {
                gui.askUserForQuantity();
                Computer computer = new Computer(5000, 122, 3 + optionsProvider.readInt(), "computer");
                getShopProductList().set(0, computer);
                gui.printAddProductToDB(computer.getName());
            }
            case '2' -> {
                gui.askUserForQuantity();
                Mouse mouse = new Mouse(300, 124, 50, "mouse");
                getShopProductList().set(2, mouse);
                gui.printAddProductToDB(mouse.getName());
            }
            case '3' -> {
                gui.askUserForQuantity();
                Keyboard keyboard = new Keyboard(600, 125, 11332 + optionsProvider.readInt(), "keyboard");
                getShopProductList().set(3, keyboard);
                gui.printAddProductToDB(keyboard.getName());
            }
            case '4' -> {
                gui.askUserForQuantity();
                Monitor monitor = new Monitor(300, 123, 6 + optionsProvider.readInt(), "monitor");
                getShopProductList().set(1, monitor);
                gui.printAddProductToDB(monitor.getName());
            }
            case '5' -> {
                gui.askUserForQuantity();
                Hardrive hardrive = new Hardrive(800, 126, 4 + optionsProvider.readInt(), "hardrive");
                getShopProductList().set(4, hardrive);
                gui.printAddProductToDB(hardrive.getName());
            }
            case '6' -> {
                gui.askUserForQuantity();
                Pendrive pendrive = new Pendrive(30, 127, 10 + optionsProvider.readInt(), "pendrive");
                getShopProductList().set(5, pendrive);
                gui.printAddProductToDB(pendrive.getName());
            }
            default -> gui.printNothingAdded();
        }
    }

    public void buyProduct() throws IOException {


        switch ((optionsProvider.readChar("Insert your choice:"))) {
            case '1' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= shopProductList.get(0).getQuantity()) {
                    shopProductList.get(0).setQuantity(shopProductList.get(0).getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(shopProductList.get(0).getName(), chosenQuantity, chosenQuantity * shopProductList.get(0).getPrize());
                } else gui.unsuccessfullyBought();
            }
            case '2' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= shopProductList.get(2).getQuantity()) {
                    shopProductList.get(2).setQuantity(shopProductList.get(2).getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(shopProductList.get(2).getName(), chosenQuantity, chosenQuantity * shopProductList.get(2).getPrize());
                } else gui.unsuccessfullyBought();
            }
            case '3' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= shopProductList.get(3).getQuantity()) {
                    shopProductList.get(0).setQuantity(shopProductList.get(3).getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(shopProductList.get(3).getName(), chosenQuantity, chosenQuantity * shopProductList.get(3).getPrize());
                } else gui.unsuccessfullyBought();
            }
            case '4' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= shopProductList.get(1).getQuantity()) {
                    shopProductList.get(1).setQuantity(shopProductList.get(1).getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(shopProductList.get(1).getName(), chosenQuantity, chosenQuantity * shopProductList.get(1).getPrize());
                } else gui.unsuccessfullyBought();
            }
            case '5' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= shopProductList.get(4).getQuantity()) {
                    shopProductList.get(4).setQuantity(shopProductList.get(4).getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(shopProductList.get(4).getName(), chosenQuantity, chosenQuantity * shopProductList.get(4).getPrize());
                    ;
                } else gui.unsuccessfullyBought();
            }
            case '6' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();
                if (chosenQuantity <= shopProductList.get(5).getQuantity()) {
                    shopProductList.get(5).setQuantity(shopProductList.get(5).getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(shopProductList.get(5).getName(), chosenQuantity, chosenQuantity * shopProductList.get(5).getPrize());
                } else gui.unsuccessfullyBought();
            }

            default -> System.out.println("--Wrong credentials--");
        }
    }

}


