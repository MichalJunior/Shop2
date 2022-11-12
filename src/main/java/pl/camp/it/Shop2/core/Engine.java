package pl.camp.it.Shop2.core;

import java.util.Scanner;

import pl.camp.it.Shop2.Authenticator;
import pl.camp.it.Shop2.database.ProductDB;
import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;


public class Engine {
    public static void start() {

        Scanner scanner = new Scanner(System.in);
        ProductDB productDB = new ProductDB();
        final UserDB userDB = new UserDB();
        GUI.printIntroducing();
        boolean isWorking = Authenticator.tryAuthenticate(GUI.readLoginAndPassword());

        while (isWorking) {
            GUI.printMENU();
            switch (scanner.nextInt()) {
                case 1:
                    productDB.printListOfAvailableProducts();
                    break;
                case 2: {
                    GUI.printBuyAnnouncement();
                    GUI.printProductsPanel();
                    productDB.buyProduct();
                    break;
                }
                case 3: {
                    if (UserDB.getLoggedUser().getRole() == User.Role.isAdmin) {
                        GUI.printAddingAnnouncement();
                        GUI.printProductsPanel();
                        productDB.addProduct();
                    } else GUI.printWarning();
                    break;
                }
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
