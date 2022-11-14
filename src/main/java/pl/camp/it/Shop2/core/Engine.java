package pl.camp.it.Shop2.core;

import java.io.IOException;

import pl.camp.it.Shop2.Authenticator;
import pl.camp.it.Shop2.Editor.FileEdytor;
import pl.camp.it.Shop2.OptionsProvider;
import pl.camp.it.Shop2.database.ProductDB;
import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;


public class Engine {
    public static void start() {
        try {
            ProductDB productDB = new ProductDB();
            Authenticator authenticator = new Authenticator();
            UserDB userDB = new UserDB();
            OptionsProvider optionsProvider = new OptionsProvider();
            GUI gui = new GUI();
            FileEdytor fileEdytor = new FileEdytor();


            boolean successfulLogged = false;
        //    productDB.listOfProducts();
            boolean flag = true;
            fileEdytor.readFile();

            while (flag) {
                gui.printIntroducing();
                char choice = gui.registerOrLogin();

                switch (choice) {
                    case '1':
                        userDB.addUserToDB();
                        break;
                    case '2': {

                        successfulLogged = authenticator.tryAuthenticate();
                        flag = false;
                        break;
                    }
                    default:
                        System.out.println("wrong choice");
                }
            }

            while (successfulLogged) {
                gui.printMENU();

                switch (optionsProvider.readChar("Insert your choice:")) {
                    case '1' -> productDB.printListOfAvailableProducts();//Products metod show list
                    case '2' -> {
                        gui.printBuyAnnouncement(); // products buy product
                        gui.printProductsPanel();
                        productDB.buyProduct();
                    }
                    case '3' -> {
                        System.out.println("           ***  Thanks for visiting my shop  *** :)");
                        fileEdytor.persistToFileProductsAndUsers(productDB.getShopProductList(),UserDB.getUsers());

                        System.exit(0);
                    }
                    case '4' -> {
                        if (UserDB.getLoggedUser().getRole() == User.Role.isAdmin) {  //Productrs addproductby admin
                            gui.printAddingAnnouncement();
                            gui.printProductsPanel();
                            productDB.addProduct();
                        } else gui.printAdminWarning();
                    }
                    case '5' -> {
                        if (UserDB.getLoggedUser().getRole() == User.Role.isAdmin) {  //Administration addAdminRights
                            userDB.makeUserAdmin();
                        } else gui.printAdminWarning();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
