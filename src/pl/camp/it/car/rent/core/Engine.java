package pl.camp.it.car.rent.core;

import java.util.Scanner;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.ProductDB;
import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;


public class Engine {
    public static void start() {

        Scanner scanner = new Scanner(System.in);
        ProductDB productDB = new ProductDB();
        final UserDB userDB = new UserDB();
        GUI.printIntroducing();
        boolean isWorking = Authenticator.tryAuthenticate(userDB);

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
                    if (Authenticator.loggedUser.getRole() == User.Role.isAdmin) {
                        GUI.printAddingAnnouncement();
                        GUI.printProductsPanel();
                        productDB.addProduct();
                    }else GUI.printWarning();
                    break;
                }
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
