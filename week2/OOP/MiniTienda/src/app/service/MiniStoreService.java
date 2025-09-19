package app.service;

import app.interfaces.IProduct;
import app.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

import static app.util.InputCheck.*;

public class MiniStoreService implements IProduct {
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

    @Override
    public void addProduct(Product product, int stockProduct) {
        if (stockPerName.containsKey(product.getName())) {
            showWarningMessage("Product " + product.getName() + " already exists in the inventory.","Product already exists");
        } else {
            listProducts.add(product);
            stockPerName.put(product.getName(), stockProduct);

            double[] newArrayPrices = new double[prices.length + 1];
            for (int i = 0; i < prices.length; i++) {
                newArrayPrices[i] = prices[i];
            }
            newArrayPrices[prices.length] = product.getPrice();
            prices = newArrayPrices;

            showSuccessMessage("Product added successfully.");
        }
    }

    @Override
    public void listProducts() {
        if (listProducts.isEmpty()){
            showWarningMessage("The inventory is empty","Inventory Empty");
        } else {
            StringBuilder allProducts = new StringBuilder();

            allProducts.append("---------- List Products ----------\n".toUpperCase());
            for (Product product : listProducts) {
                allProducts.append("------ ").append(product.getName().toUpperCase()).append(" ------").append("\n").append("Price: $").append(String.format("%,10.2f",(product.getPrice()))).append("\n").append("Stock: [").append(stockPerName.get(product.getName())).append("]\n").append("Description: \n").append(product.getDescription()).append("\n\n");
            }

            showInfoMessage(String.valueOf(allProducts),"List Products");
        }
    }

    @Override
    public void buyProduct(String nameProduct) {

        if (!stockPerName.containsKey(nameProduct)){
            showWarningMessage("Product no found","Error");
        }

        int currentStock = stockPerName.get(nameProduct);

        if (listProducts.isEmpty()) {
            showWarningMessage("The inventory is empty", "Inventory Empty");
            return;
        }

        int amountProduct = requestInteger(nameProduct.toUpperCase() + " STOCK: " + currentStock + "\nEnter " + nameProduct.toUpperCase() + " amount to buy","The amount must be a valid integer.");

        if (currentStock < amountProduct){
            showWarningMessage("Insufficient stock","Error");
            return;
        }

        double priceProduct = 0.0;

        for (Product product : listProducts){
            if (product.getName().equals(nameProduct)){
                priceProduct = product.getPrice();
            }
        }

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Do you want to buy " + amountProduct + " units of " + nameProduct + " for $" + String.format("%,10.2f", (priceProduct* amountProduct)) + "?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            stockPerName.put(nameProduct, currentStock - amountProduct);
            totalPurchases += priceProduct * amountProduct;

            showSuccessMessage("Products bought successful");
        }




    }
}
