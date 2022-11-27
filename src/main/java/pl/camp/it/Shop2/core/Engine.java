package pl.camp.it.Shop2.core;

import java.io.IOException;

import pl.camp.it.Shop2.authenticators.Authenticator;
import pl.camp.it.Shop2.Editors.FileEdytor;
import pl.camp.it.Shop2.providers.OptionsProvider;
import pl.camp.it.Shop2.databases.ProductDB;
import pl.camp.it.Shop2.databases.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;


public class Engine {


    private static final Engine instance = new Engine();
    private final ProductDB productDB = ProductDB.getInstance();
    private final Authenticator authenticator = Authenticator.getInstance();
    private final UserDB userDB = UserDB.getInstance();
    private final OptionsProvider optionsProvider = OptionsProvider.getInstance();
    private final GUI gui = GUI.getInstance();
    private final FileEdytor fileEdytor = FileEdytor.getInstance();
    private Engine(){}

    public void start() {
        try {
            boolean successfulLogged = false;
            boolean flag = true;
            fileEdytor.readFile();
            //        ***    !!!!!           Admin login and password:admin / Usual user login and password :michal             !!!
            while (flag) {
                gui.printIntroducing();
                char choice = gui.registerOrLogin();
                switch (choice) {
                    case '1' -> userDB.addUserToDB();
                    case '2' -> {
                        successfulLogged = authenticator.tryAuthenticate();
                        flag = false;
                    }
                    default -> System.out.println("wrong choice");
                }
            }
            while (successfulLogged) {
                gui.printMENU();

                switch (optionsProvider.readChar("Insert your choice:")) {
                    case '1' -> productDB.printListOfAvailableProducts();
                    case '2' -> {
                        gui.printBuyAnnouncement();
                        gui.printProductsPanel();
                        productDB.buyProduct();
                    }
                    case '3' -> {
                        gui.printEnd();
                        fileEdytor.persistToFileProductsAndUsers(productDB.getShopProductList(), userDB.getUsers());
                        System.exit(0);
                    }
                    case '4' -> {
                        if (userDB.getLoggedUser().getRole() == User.Role.isAdmin) {
                            gui.printAddingAnnouncement();
                            gui.printProductsPanel();
                            productDB.addProduct();
                        } else gui.printAdminWarning();
                    }
                    case '5' -> {
                        if (userDB.getLoggedUser().getRole() == User.Role.isAdmin) {
                            userDB.makeUserAdmin();
                        } else gui.printAdminWarning();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Engine getInstance(){
        return instance;
    }
}
