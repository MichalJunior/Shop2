package pl.camp.it.Shop2.core;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.Shop2.authenticators.Authenticator;
import pl.camp.it.Shop2.Editors.FileEditor;
import pl.camp.it.Shop2.interfaces.IProductDB;
import pl.camp.it.Shop2.interfaces.IUserDB;
import pl.camp.it.Shop2.providers.OptionsProvider;
import pl.camp.it.Shop2.gui.GUI;
import pl.camp.it.Shop2.model.User;

@Component
public class Engine {
    @Autowired
    private IProductDB productDB;
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private IUserDB userDB;
    @Autowired
    private OptionsProvider optionsProvider;
    @Autowired
    private GUI gui;
    @Autowired
    private FileEditor fileEditor;

    public void start() throws IOException {

        boolean successfulLogged = false;
        boolean flag = true;
        fileEditor.readFile();
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
                    fileEditor.persistToFileProductsAndUsers(productDB.getShopProductList(), userDB.getUsers());
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

    }
}