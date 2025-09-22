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
            return;
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

        int confirm = requestConfirm(
                "Do you want to buy " + amountProduct + " units of " + nameProduct + " for $" + String.format("%,10.2f", (priceProduct* amountProduct)) + "?",
                "Confirmation");

        if (confirm == JOptionPane.YES_OPTION) {
            stockPerName.put(nameProduct, currentStock - amountProduct);
            totalPurchases += priceProduct * amountProduct;

            showSuccessMessage("Products bought successful");
        }
    }

    @Override
    public void showStatistics() {
        if (listProducts.isEmpty()) {
            showWarningMessage("The inventory is empty", "Inventory Empty");
            return;
        }

        int maxPriceIndex = 0;
        int minPriceIndex = 0;
        double maxPrice = prices[0];
        double minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
                maxPriceIndex = i;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minPriceIndex = i;
            }
        }

        Product mostExpensive = listProducts.get(maxPriceIndex);
        Product leastExpensive = listProducts.get(minPriceIndex);

        showSuccessMessage(String.format(
                "Most Expensive Product: %s (Price: $%.2f)\nLeast Expensive Product: %s (Price: $%.2f)",
                mostExpensive.getName(), mostExpensive.getPrice(),
                leastExpensive.getName(), leastExpensive.getPrice()
        ));
    }

    @Override
    public void searchProduct(String nameProduct) {
        nameProduct = nameProduct.toLowerCase();

        StringBuilder productDetail = new StringBuilder();

        for (Product product : listProducts){
            String currentProduct = product.getName();
            if (currentProduct.contains(nameProduct)){
                String name = product.getName();
                double priceProduct = product.getPrice();
                int stockProduct = stockPerName.get(product.getName());

                productDetail.append("PRODUCT: ").append(name.toUpperCase()).append("\nPRICE: $").append(String.format("%,10.2f", priceProduct)).append("\nSTOCK: ").append(stockProduct).append("\n-------------------------\n");
            }else {
                productDetail.append("Product no found");
                break;
            }
        }

        showInfoMessage(String.valueOf(productDetail),"Search");
    }

    @Override
    public void exit() {
        showInfoMessage("Total purchases in this session: $" + String.format("%,10.2f", totalPurchases),
                "Final Ticket");
    }
}
