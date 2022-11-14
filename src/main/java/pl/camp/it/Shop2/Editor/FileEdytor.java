package pl.camp.it.Shop2.Editor;

import pl.camp.it.Shop2.database.ProductDB;
import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.model.*;

import javax.security.auth.login.CredentialException;
import java.io.*;
import java.util.List;

public class FileEdytor {

    private String DATABASE_FILE = "bd.txt";
    ProductDB productDB = new ProductDB();

    public void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = convertDataToProduct(line);
                if (product != null) {
                    productDB.getShopProductList().add(product);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("*** FILE PROBLEM ***");
        }
    }

    private void convertDataToProduct(String data) {
        String[] productDate = data.split(";");
        switch (productDate[0]) {
            case "Computer" -> {
                productDB.getShopProductList().add() new Computer(productDate);
            }
            case "Mouse" -> {
                return new Mouse(productDate);
            }
            case "Keyboard" -> {
                return new Keyboard(productDate);
            }
            case "Hardrive" -> {
                return new Hardrive(productDate);
            }
            case "Monitor" -> {
                return new Monitor(productDate);
            }
            case "Pendrive" -> {
                return new Pendrive(productDate);
            }
            case "User" return new User(productDate);
            default:
                try {
                    throw new CredentialException();
                } catch (CredentialException e) {
                    e.printStackTrace();
                }

            //System.out.println("Corrupted line in DB: " + line);
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

}
