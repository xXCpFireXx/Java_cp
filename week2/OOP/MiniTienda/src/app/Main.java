package app;

import app.model.Appliance;
import app.model.Food;
import app.model.Product;
import app.service.MiniStoreService;
import app.util.InputCheck;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        MiniStoreService service = new MiniStoreService();

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
                            6. Exit with final receipt.""".toUpperCase(),
                    "Mini Shop - Menu".toUpperCase(),
                    JOptionPane.QUESTION_MESSAGE);

            if (optionMenu == null) {
                break;
            }

            switch (optionMenu) {
                case "1":
                    addProductMenu(service);
                    break;
                case "2":
                    service.listProducts();
                    break;
                case "3":
                    buyProductMenu(service);
                    break;
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
                    InputCheck.showWarningMessage("Invalid option","Error");
                    break;
            }

        } while (breakDoWhile != 6);
    }


    public static void addProductMenu(MiniStoreService service){
            String[] typeOption = {"Food", "Appliance"};
            int productType = JOptionPane.showOptionDialog(null,
                    "What type of product do you want to add?", "Select Type",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    typeOption,
                    typeOption[0]);

            String name = InputCheck.requestString(
                    "Enter the product name",
                    "The name cannot be empty.");

            double price = InputCheck.requestDouble(
                    "Enter the product price",
                    "The price must be a valid number.");

            int stock = InputCheck.requestInteger(
                    "Enter the stock",
                    "The stock must be a valid integer.");

            Product product = (productType == 0) ? new Food(name, price) : new Appliance(name, price);
            service.addProduct(product, stock);
    }

    public static void buyProductMenu(MiniStoreService service){

        String name = InputCheck.requestString(
                "Enter the name of the product to buy",
                "The name cannot be empty.");

        service.buyProduct(name);
    }

}
