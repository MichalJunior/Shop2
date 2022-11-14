package pl.camp.it.Shop2.Editor;

import pl.camp.it.Shop2.database.UserDB;
import pl.camp.it.Shop2.model.Product;
import pl.camp.it.Shop2.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileEdytor {

    private String DATABASE_FILE = "bd.txt";

    public void persistToFileProductsAndUsers(List<Product> productList, List<User> userList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE));

            for (int i = 0; i < productList.size(); i++) {
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
        return user.getLogin() +
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
