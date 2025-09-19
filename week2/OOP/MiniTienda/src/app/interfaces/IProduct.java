package app.interfaces;

import app.model.Product;

public interface IProduct {

    void addProduct(Product product, int stockProduct);
    void listProducts();
    void buyProduct(String nameProduct);
}
