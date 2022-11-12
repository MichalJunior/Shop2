package pl.camp.it.Shop2.gui;


import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.Shop2.Authenticator;
import pl.camp.it.Shop2.database.ProductDB;
import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class GUI {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void printIntroducing() {
        System.out.println("-----------------Welcome in my virtual shop--------------");
    }

    public static void printMENU() {
        System.out.print(" +----------------------------MENU---------------------------+\n1.View list of products\n2.Buy product\n3.Add product\n" +
                "4.Exit\nInsert your choice:");
    }

    public static void printProductsPanel() {
        System.out.print("1.computer\n2.mouse\n3.keyboard\n4.monitor\n5.hardrive\n6.pendrive\nInsert your choice:");
    }

    public static void printAvailableProducts(HashMap<ProductDB.Product, Integer> availableProducts) {
        System.out.println("---available products " + availableProducts);
    }

    public static void printAddingAnnouncement() {
        System.out.println("-----What product would you add?-----");
    }

    public static void printAddProductToDB(String product) {
        System.out.println("+++" + product + " added to shop+++");
    }


    public static void printNothingAdded() {
        System.out.println("---Nothing added---");
    }


    public static void printBuyAnnouncement() {
        System.out.println("--- what product would you buy? ---");
    }

    public static void printSuccessfullyBought(String nameProduct, int quantity, int result) {
        System.out.println("Successfully Bought " + nameProduct + " x " + quantity + " = " + result + "PLN");
    }

    public static void askUserForQuantity() {
        System.out.print("Number of products?:");
    }

    public static void unsuccessfullyBought() {
        System.out.println(" -----------  number higher than available,try again ----------- ");
    }

    public static User readLoginAndPassword() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Login:");
        String login = scanner.nextLine();
        System.out.print("Password:");
        String password = DigestUtils.md5Hex(scanner.nextLine() + Authenticator.seed);
        return new User(login, password);
    }

    public static void printWarning() {
        System.out.println("--You can not add product not being Admin--");
    }

    public static void printWrongCredentials() {
        System.out.println("--Wrong credentials,try again --");
    }

    public static void registerOrLogin() throws IOException {
        System.out.print("------Would you register or log in?------\n1-register/2-log in :");

    }
}

