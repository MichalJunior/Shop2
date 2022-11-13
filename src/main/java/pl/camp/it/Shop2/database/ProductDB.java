package pl.camp.it.Shop2.database;

import pl.camp.it.Shop2.OptionsProvider;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.*;

import java.io.IOException;
import java.util.*;

public class ProductDB {
    private final GUI gui = new GUI();
    private final OptionsProvider optionsProvider = new OptionsProvider();


    private final List<Product> shopProductList = new ArrayList<>();

    List<String> availableProducts = new ArrayList<>();


    public List<Product> getShopProductList() {
        return shopProductList;
    }

    Product computer = new Computer(5000, 122, 3, "computer");
    Product monitor = new Monitor(300, 123, 6, "monitor");
    Product mouse = new Mouse(300, 124, 50, "mouse");
    Product keyboard = new Keyboard(600, 125, 11332, "keyboard");
    Product hardrive = new Hardrive(800, 126, 4, "hardrive");

    Product pendrive = new Pendrive(30, 127, 10, "pendrive");

    public void listOfProducts() {
        shopProductList.add(computer);
        shopProductList.add(monitor);
        shopProductList.add(mouse);
        shopProductList.add(keyboard);
        shopProductList.add(hardrive);
        shopProductList.add(pendrive);

    }


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
                getShopProductList().set(0, new Computer(5000, 122, 3 + optionsProvider.readInt(), "computer"));
                gui.printAddProductToDB(computer.getName());
            }
            case '2' -> {
                gui.askUserForQuantity();
                getShopProductList().set(2, new Mouse(300, 124, 50, "mouse"));
                gui.printAddProductToDB(mouse.getName());
            }
            case '3' -> {
                gui.askUserForQuantity();
                getShopProductList().set(3, new Keyboard(600, 125, 11332 + optionsProvider.readInt(), "keyboard"));
                gui.printAddProductToDB(keyboard.getName());
            }
            case '4' -> {
                gui.askUserForQuantity();
                getShopProductList().set(1, new Monitor(300, 123, 6 + optionsProvider.readInt(), "monitor"));
                gui.printAddProductToDB(monitor.getName());
            }
            case '5' -> {
                gui.askUserForQuantity();
                getShopProductList().set(4, new Hardrive(800, 126, 4 + optionsProvider.readInt(), "hardrive"));
                gui.printAddProductToDB(hardrive.getName());
            }
            case '6' -> {
                gui.askUserForQuantity();
                getShopProductList().set(5, new Pendrive(30, 127, 10 + optionsProvider.readInt(), "pendrive"));
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

                if (chosenQuantity <= computer.getQuantity()) {
                    computer.setQuantity(computer.getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(computer.getName(), chosenQuantity, chosenQuantity * computer.getPrize());
                } else gui.unsuccessfullyBought();
            }
            case '2' -> {
                gui.askUserForQuantity();
                int chosenQuantity = optionsProvider.readInt();

                if (chosenQuantity <= mouse.getQuantity()) {
                    mouse.setQuantity(mouse.getQuantity() - chosenQuantity);
                    gui.printSuccessfullyBought(mouse.getName(), chosenQuantity, chosenQuantity * mouse.getPrize());
                } else gui.unsuccessfullyBought();
            }
                case '3' -> {
                    gui.askUserForQuantity();
                    int chosenQuantity = optionsProvider.readInt();
                    if (chosenQuantity <= keyboard.getQuantity()) {
                        keyboard.setQuantity(keyboard.getQuantity() - chosenQuantity);
                        gui.printSuccessfullyBought(keyboard.getName(), chosenQuantity, chosenQuantity * keyboard.getPrize());
                    } else gui.unsuccessfullyBought();
                }
                    case '4' -> {
                        gui.askUserForQuantity();
                        int chosenQuantity = optionsProvider.readInt();

                        if (chosenQuantity <= monitor.getQuantity()) {
                            monitor.setQuantity(monitor.getQuantity() - chosenQuantity);
                            gui.printSuccessfullyBought(monitor.getName(), chosenQuantity, chosenQuantity * monitor.getPrize());
                        } else gui.unsuccessfullyBought();
                    }
                    case '5' -> {
                        gui.askUserForQuantity();
                        int chosenQuantity = optionsProvider.readInt();

                        if (chosenQuantity <= hardrive.getQuantity()) {
                            hardrive.setQuantity(hardrive.getQuantity() - chosenQuantity);
                            gui.printSuccessfullyBought(hardrive.getName(), chosenQuantity, chosenQuantity * hardrive.getPrize());
                        } else gui.unsuccessfullyBought();
                    }
                    case '6' -> {
                        gui.askUserForQuantity();
                        int chosenQuantity = optionsProvider.readInt();

                        if (chosenQuantity <= pendrive.getQuantity()) {
                            pendrive.setQuantity(pendrive.getQuantity() - chosenQuantity);
                            gui.printSuccessfullyBought(pendrive.getName(), chosenQuantity, chosenQuantity * pendrive.getPrize());
                        } else gui.unsuccessfullyBought();
                    }

                    default -> System.out.println("--Wrong credentials--");
                }
            }

        }


