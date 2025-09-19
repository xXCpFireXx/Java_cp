package app;

import app.service.MiniStoreService;
import app.util.InputCheck;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int breakDoWhile = 0;
        do {
            // Menu options
            String optionMenu = JOptionPane.showInputDialog(
                    null,
                    """
                            1. Add product.
                            2. List inventory.
                            3. Purchase product.
                            4. Display statistics (cheapest and most expensive).
                            5. Search for product by name.
                            6. Exit with final receipt.""",
                    "Mini Shop - Menu",
                    JOptionPane.PLAIN_MESSAGE);

            if (optionMenu == null) {
                break;
            }

            switch (optionMenu) {
                case "1":


                    String name = InputCheck.requestString(
                            "Enter the product name",
                            "The name cannot be empty."
                    );

                    // Request product price
                    double price = InputCheck.requestDouble(
                            "Enter the product price",
                            "The price must be a valid number."
                    );

                    // Request initial stock
                    int stock = InputCheck.requestInteger(
                            "Enter the initial stock",
                            "The stock must be a valid integer."
                    );

                    // Create product and add to inventory
//                    Product product = (productType == 1) ? new Food(name, price) : new Appliance(name, price);
//                    MiniStoreService.addProduct(product, stock);
                    InputCheck.showSuccessMessage("Product added successfully.");
                    break;
//                case "2":
//                    listStock();
//                    break;
//                case "3":
//                    buyProduct();
//                    break;
//                case "4":
//                    showStatistics();
//                    break;
//                case "5":
//                    searchProduct();
//                    break;
//                case "6":
//                    exit();
//                    breakDoWhile = 6;
//                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid option",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (breakDoWhile != 6);
    }

}
