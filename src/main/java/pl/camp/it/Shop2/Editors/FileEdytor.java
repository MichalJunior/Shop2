package pl.camp.it.Shop2.Editors;

import pl.camp.it.Shop2.databases.ProductDB;
import pl.camp.it.Shop2.databases.UserDB;
import pl.camp.it.Shop2.model.*;

import javax.security.auth.login.CredentialException;
import java.io.*;
import java.util.List;

public class FileEdytor {
    private final ProductDB productDB = ProductDB.getInstance();
    private final UserDB userDB = UserDB.getInstance();
    private final String DATABASE_FILE = "bd.txt";
    private static final FileEdytor instance = new FileEdytor();
   private FileEdytor(){}

    public void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                convertDataToProductOrUserAddToLists(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("*** FILE PROBLEM ***");
        }
    }

    private void convertDataToProductOrUserAddToLists(String data) {
        String[] productDate = data.split(";");
        switch (productDate[0]) {
            case "Computer" -> productDB.getShopProductList().add(new Computer(productDate));

            case "Mouse" -> productDB.getShopProductList().add(new Mouse(productDate));

            case "Keyboard" -> productDB.getShopProductList().add(new Keyboard(productDate));

            case "Hardrive" -> productDB.getShopProductList().add(new Hardrive(productDate));

            case "Monitor" -> productDB.getShopProductList().add(new Monitor(productDate));

            case "Pendrive" -> productDB.getShopProductList().add(new Pendrive(productDate));

            case "User" -> userDB.getUsers().add(new User(productDate));
            default -> {
                try {
                    throw new CredentialException();
                } catch (CredentialException e) {
                    e.printStackTrace();
                }
                System.out.println("Corrupted line in DB");
            }
        }
    }

    public void persistToFileProductsAndUsers(List<Product> productList, List<User> userList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE));
            writer.write(convertProductToData(productList.get(0)));

            for (int i = 1; i < productList.size(); i++) {
                writer.newLine();
                writer.write(convertProductToData(productList.get(i)));
                writer.flush();
            }
            writer.newLine();
            writer.write(convertUserToData(userList.get(0)));
            for (int j = 1; j < userList.size(); j++) {
                writer.newLine();
                writer.write(convertUserToData(userList.get(j)));
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something Gone wrong during persisting to file");
            e.printStackTrace();
        }
    }

    public String convertUserToData(User user) {
        return "User" +
                ";" +
                user.getLogin() +
                ";" +
                user.getPassword() +
                ";" +
                user.getRole();

    }

    public String convertProductToData(Product product) {
        return product.getClass().getSimpleName() +
                ";" +
                product.getPrize() +
                ";" +
                product.getKeyProduct() +
                ";" +
                product.getQuantity();
    }
    public static FileEdytor getInstance(){
       return instance;
    }

}
