package pl.camp.it.Shop2.gui;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.Shop2.providers.OptionsProvider;
import pl.camp.it.Shop2.databases.UserDB;
import pl.camp.it.Shop2.model.User;

import java.io.IOException;
import java.util.List;

@Component

public class GUI {
    @Autowired

    private OptionsProvider optionsProvider;
    @Autowired
    private  UserDB userDB;
    private static final String seed = "GdySieNieMaCoSieLubiToSieLubiCoSieMa";
    public User readLoginAndPassword() throws IOException {
        System.out.print("Login:");
        String login = optionsProvider.readString();
        System.out.print("Password:");
        String password = optionsProvider.readString();
        if (login.length() >= 3 && password.length() >= 3) {
            return new User(login, DigestUtils.md5Hex(password + seed));
        } else {
            System.out.println("----Login & password must be longer than 2 chars---");
            return readLoginAndPassword();
        }
    }

    public void printIntroducing() {
        System.out.println("-----------------Welcome in my virtual shop--------------");
    }

    public void printMENU() {
        System.out.println(" +----------------------------MENU---------------------------+\n1.View list of products");
        if (userDB.getLoggedUser().getRole() == User.Role.isUser) {
            System.out.println("2.Buy product");
        }
        System.out.println("3.Exit");
        if (userDB.getLoggedUser().getRole() == User.Role.isAdmin) {
            System.out.println("4. * Add product * ");
            System.out.println("5. * Make User Admin *");
        }
    }

    public void printProductsPanel() {
        System.out.println("1.computer\n2.mouse\n3.keyboard\n4.monitor\n5.hardrive\n6.pendrive");
    }

    public void printAvailableProducts(List<String> availableProducts) {
        System.out.println("---available products " + availableProducts);
    }

    public void printAddingAnnouncement() {
        System.out.println("-----What product would you add?-----");
    }

    public void printAddProductToDB(String product) {
        System.out.println("+++" + product + " added to shop+++");
    }


    public void printNothingAdded() {
        System.out.println("---Nothing added---");
    }


    public void printBuyAnnouncement() {
        if (userDB.getLoggedUser().getRole() == (User.Role.isAdmin)) {
            System.out.println("***    PO CO KUPUJESZ WŁASNY TOWAR BARANIE???    ***");
        } else System.out.println("--- what product would you buy? ---");

    }

    public void printSuccessfullyBought(String nameProduct, int quantity, int result) {
        System.out.println("Successfully Bought " + nameProduct + " x " + quantity + " = " + result + "PLN");
    }

    public void askUserForQuantity() {
        System.out.print("Number of products?:");
    }

    public void unsuccessfullyBought() {
        System.out.println(" -----------  number higher than available,try again ----------- ");
    }


    public void printAdminWarning() {
        System.out.println(" *** YOU ARE NOT ADMIN ***");
    }

    public void printWrongCredentials() {
        System.out.println("--Wrong credentials,try again --");
    }

    public char registerOrLogin() throws IOException {
        return optionsProvider.readChar("------Would you register or log in?------\n1-register/2-log in :");
    }

    public void printEnd() {
        System.out.println(" ***  Thanks for visiting my shop  *** :)");
    }
}

