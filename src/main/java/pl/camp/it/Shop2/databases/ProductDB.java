package pl.camp.it.Shop2.databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.Shop2.interfaces.IProductDB;
import pl.camp.it.Shop2.providers.OptionsProvider;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.*;

import java.io.IOException;
import java.util.*;

@Component
public class ProductDB implements IProductDB {
    @Autowired
    private GUI gui;
    @Autowired
    private OptionsProvider optionsProvider;
    List<String> availableProducts = new ArrayList<>();
    private static final List<Product> shopProductList = new ArrayList<>();


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
                Mouse mouse = new Mouse(300, 124, 50 + optionsProvider.readInt(), "mouse");
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

    public List<Product> getShopProductList() {
        return shopProductList;
    }
}


