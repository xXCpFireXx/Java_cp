import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main {

    // ------- Data structures and variable -------
    // Stores product names, prices, stock, and total purchases
    static ArrayList<String> nameProducts = new ArrayList<>();
    static double[] prices = new double[0];
    static HashMap<String, Integer> stock = new HashMap<>();
    static double totalPurchases = 0;

    // ------- Main Method -------
    // Menu-driven loop for user interaction
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
                    createProduct();
                    break;
                case "2":
                    listStock();
                    break;
                case "3":
                    buyProduct();
                    break;
                case "4":
                    showStatistics();
                    break;
                case "5":
                    searchProduct();
                    break;
                case "6":
                    exit();
                    breakDoWhile = 6;
                    break;
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

    // ------- Utility Methods -------
    // Helpers for managing products
    static void addProduct(String name, double price, int amount) {
        nameProducts.add(name);
        expandPrices(price);
        stock.put(name, amount);
    }

    static void expandPrices(double newPrice) {
        double[] newArrayPrices = new double[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            newArrayPrices[i] = prices[i];
        }
        newArrayPrices[prices.length] = newPrice;
        prices = newArrayPrices;
    }

    static int indexOfName(String name) {
        for (int index = 0; index < nameProducts.size(); index++) {
            String nameProduct = nameProducts.get(index);
            if (nameProduct.equals(name)) {
                return index;
            }
        }
        return -2; // Non-standard "not found" value
    }

    // ------- Create Product ------
    // Adds product with name, price, stock
    static void createProduct() {
        double priceProduct;
        int amountProduct;
// ----------------------------- Name --------------------------------
        String nameProduct = JOptionPane.showInputDialog(
                null,
                "Enter the product's name",
                "Product Name",
                JOptionPane.PLAIN_MESSAGE);

        if (nameProduct == null) {
            return;
        }

        nameProduct = nameProduct.toLowerCase();

        // Verifica si lo ingresado esta vacio
        if (nameProduct.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid product name",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si ya existe (no duplicados)
        if (indexOfName(nameProduct) != -2) {
            JOptionPane.showMessageDialog(
                    null,
                    "Product already exits",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
// ---------------------------- Price -----------------------------------
        try {
            priceProduct = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            null,
                            "Enter " + nameProduct.toUpperCase() + " price",
                            nameProduct.toUpperCase() + " Price",
                            JOptionPane.PLAIN_MESSAGE));

            if (priceProduct <= 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Price must be positive number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Enter a valid number",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } catch (NullPointerException e) {
            return;
        }
// -------------------------- Amount --------------------------------------
        try {
            amountProduct = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            null,
                            "Enter " + nameProduct.toUpperCase() + " amount",
                            nameProduct.toUpperCase() + " Amount",
                            JOptionPane.PLAIN_MESSAGE));

            if (amountProduct < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Amount must be positive number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Enter a valid number",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } catch (NullPointerException e) {
            return;
        }
// --------------------- Add product ---------------------------
        addProduct(nameProduct, priceProduct, amountProduct);
        JOptionPane.showMessageDialog(
                null,
                "Product added successful",
                "Successful",
                JOptionPane.PLAIN_MESSAGE);
    }

    // -------- List Stock --------
    // Displays all products
    static void listStock() {
        if (nameProducts.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Stock Empty",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String listProducts = "";
        for (int i = 0; i < nameProducts.size(); i++) {

            String nameProduct = nameProducts.get(i);
            double priceProduct = prices[i];
            int stockProduct = stock.get(nameProduct);

            listProducts += "PRODUCT: " + nameProduct.toUpperCase() + "\nPRICE: $" + String.format("%,10.2f", priceProduct) + "\nSTOCK: " + stockProduct + "\n-------------------------\n";
        }
        JOptionPane.showMessageDialog(
                null,
                listProducts,
                "List Products",
                JOptionPane.PLAIN_MESSAGE);
    }

    // -------- Buy Product --------
    // Handles product purchases
    static void buyProduct() {
        int amountProduct;

        if (nameProducts.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Stock Empty",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nameProduct = JOptionPane.showInputDialog(
                null,
                "Enter the name of the product to buy",
                "Product Name",
                JOptionPane.PLAIN_MESSAGE);

        if (nameProduct == null) {
            return;
        }
        nameProduct = nameProduct.toLowerCase();

        // Verifica si lo ingresado esta vacio
        if (nameProduct.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid product name",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si hay producto
        if (indexOfName(nameProduct) == -2) {
            JOptionPane.showMessageDialog(
                    null,
                    "Product no found",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
// -------------------------- Amount --------------------------------------
        int currentStock = stock.get(nameProduct);
        try {
            amountProduct = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            null,
                            nameProduct.toUpperCase() + " STOCK: " + currentStock + "\nEnter " + nameProduct.toUpperCase() + " amount to buy",
                            nameProduct.toUpperCase() + " Amount",
                            JOptionPane.PLAIN_MESSAGE));

            if (amountProduct < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Amount must be positive number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Enter a valid number",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } catch (NullPointerException e) {
            return;
        }
// --------------------- Stock product ---------------------------

        if (amountProduct > currentStock) {
            JOptionPane.showMessageDialog(
                    null,
                    "Insufficient stock",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
// --------------------- Buy product ---------------------------
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Do you want to buy " + amountProduct + " units of " + nameProduct + " for $" + String.format("%,10.2f", (prices[indexOfName(nameProduct)] * amountProduct)) + "?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            stock.put(nameProduct, currentStock - amountProduct);
            totalPurchases += prices[indexOfName(nameProduct)] * amountProduct;
            JOptionPane.showMessageDialog(
                    null,
                    "Products bought successful",
                    "Successful",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // -------- Show Statistics --------
    // Shows cheapest and most expensive prices
    static void showStatistics() {
        double minPrice = Arrays.stream(prices).min().orElse(0);
        double maxPrice = Arrays.stream(prices).max().orElse(0);

        JOptionPane.showMessageDialog(
                null,
                "Cheapest price: $" + String.format("%,10.2f", minPrice) + "\nMost expensive price: $" + String.format("%,10.2f", maxPrice),
                "Minimum and Maximun Price",
                JOptionPane.PLAIN_MESSAGE);
    }

    // -------- Search Product --------
    // Searches products by partial name match
    static void searchProduct() {
        String nameProduct = JOptionPane.showInputDialog(
                null,
                "Enter product name to search",
                "Search product",
                JOptionPane.PLAIN_MESSAGE);

        if (nameProduct == null) {
            return;
        }

        nameProduct = nameProduct.toLowerCase();

        if (nameProduct.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid product name",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String productDetail = "";

        for (int i = 0; i < nameProducts.size(); i++) {
            String currentProduct = nameProducts.get(i);

            if (currentProduct.contains(nameProduct)) {
                String name = nameProducts.get(i);
                double priceProduct = prices[i];
                int stockProduct = stock.get(name);

                productDetail += "PRODUCT: " + name.toUpperCase() + "\nPRICE: $" + String.format("%,10.2f", priceProduct) + "\nSTOCK: " + stockProduct + "\n-------------------------\n";
            }
        }

        JOptionPane.showMessageDialog(
                null,
                productDetail.isEmpty() ? "No products found" : productDetail,
                "Products Searched",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    // -------- Exit --------
    // Shows total purchases and exits
    static void exit() {
        JOptionPane.showMessageDialog(
                null,
                "Total purchases in this session: $" + String.format("%,10.2f", totalPurchases),
                "Final Ticket",
                JOptionPane.PLAIN_MESSAGE);
    }

}



