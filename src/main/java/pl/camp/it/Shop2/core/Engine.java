package pl.camp.it.Shop2.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import pl.camp.it.Shop2.Authenticator;
import pl.camp.it.Shop2.database.ProductDB;
import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;


public class Engine {
    public static void start() {
        try {
            // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);
            ProductDB productDB = new ProductDB();
            final UserDB userDB = new UserDB();

            boolean successfulLogged = false;

            boolean flag = true;
            while (flag) {
                GUI.printIntroducing();
                GUI.registerOrLogin();

                switch (scanner.nextInt()) {
                    case 1:
                        UserDB.addUserToDB();
                        break;
                    case 2: {
                        successfulLogged = Authenticator.tryAuthenticate();
                        flag = false;
                        break;
                    }
                    default:
                        System.out.println("wrong choice");
                }
            }

            while (successfulLogged) {
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
                    case 5: {
                        if (UserDB.getLoggedUser().getRole() == User.Role.isAdmin) {
                            userDB.makeUserAdmin();
                            for (User user : UserDB.getUsers()) {
                                System.out.println("login:" + user.getLogin() + " password " + user.getPassword() + " role " + user.getRole());
                            }
                        } else System.out.println(" *** YOU ARE NOT ADMIN ***");

                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
