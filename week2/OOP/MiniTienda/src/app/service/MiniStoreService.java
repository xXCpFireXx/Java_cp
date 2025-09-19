package app.service;

import app.model.Product;
import java.util.ArrayList;
import java.util.HashMap;

public class MiniStoreService {
    private ArrayList<Product> listProducts;
    private HashMap<String, Integer> stockPerName;
    private double[] prices;
    private double totalPurchases;

    public MiniStoreService() {
        listProducts = new ArrayList<>();
        stockPerName = new HashMap<>();
        prices = new double[0];
        totalPurchases = 0.0;
    }

    public void addProduct(Product product, int stockProduct){

    }


}
