package pl.camp.it.Shop2.interfaces;

import pl.camp.it.Shop2.model.Product;

import java.io.IOException;
import java.util.List;

public interface IProductDB {
    void printListOfAvailableProducts() ;

    void addProduct() throws IOException;

    void buyProduct() throws IOException;

    List<Product> getShopProductList();
}
