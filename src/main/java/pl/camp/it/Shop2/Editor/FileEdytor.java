package pl.camp.it.Shop2.Editor;

import pl.camp.it.Shop2.database.ProductDB;
import pl.camp.it.Shop2.model.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileEdytor {


    ProductDB productDB = new ProductDB();


    private String DATABASE_FILE = "bd.txt";

    public void persistToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE));

           writer.write(convertToData(productDB.getShopProductList().get(0)));
            for (int i = 1; i < productDB.getShopProductList().size(); i++) {
                writer.newLine();
                writer.write(convertToData(productDB.getShopProductList().get(i)));
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something Gone wrong during persisting to file");
            e.printStackTrace();
        }
    }

    public String convertToData(Product product) {
        return new StringBuilder()
                .append(product.getClass().getSimpleName())
                .append(";")
                .append(product.getPrize())
                .append(";")
                .append(product.getKeyProduct())
                .append(";")
                .append(product.getQuantity())
                .toString();
    }
}
