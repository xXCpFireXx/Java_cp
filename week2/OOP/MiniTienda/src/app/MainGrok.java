import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            String option = JOptionPane.showInputDialog(
                null,
                "Menu:\n1. Add product\n2. List inventory\n3. Purchase product\n4. Statistics\n5. Search product\n6. Exit",
                "Menu",
                JOptionPane.QUESTION_MESSAGE
            );

//            try {
//                int optionInt = InputValidator.validateInteger(option, "Please enter a valid number.");
//                switch (optionInt) {
//                    case 1: // Add product
//                        // Request product type
//                        int productType = InputValidator.requestInteger(
//                            "Enter product type (1: Food, 2: Appliance)",
//                            "The type must be a valid number (1 or 2)."
//                        );
//                        if (productType != 1 && productType != 2) {
//                            throw new IllegalArgumentException("Invalid product type. Use 1 for Food or 2 for Appliance.");
//                        }
//
//                        // Request product name
//                        String name = InputValidator.requestString(
//                            "Enter the product name",
//                            "The name cannot be empty."
//                        );
//
//                        // Request product price
//                        double price = InputValidator.requestDouble(
//                            "Enter the product price",
//                            "The price must be a valid number."
//                        );
//
//                        // Request initial stock
//                        int stock = InputValidator.requestInteger(
//                            "Enter the initial stock",
//                            "The stock must be a valid integer."
//                        );
//
//                        // Create product and add to inventory
//                        Product product = (productType == 1) ? new Food(name, price) : new Appliance(name, price);
//                        inventory.addProduct(product, stock);
//                        InputValidator.showSuccessMessage("Product added successfully.");
//                        break;
//
//                    case 2: // List inventory
//                        String list = inventory.listInventory();
//                        InputValidator.showInfoMessage(list.isEmpty() ? "Inventory is empty" : list, "Inventory");
//                        break;
//
//                    case 3: // Purchase product
//                        String purchaseName = InputValidator.requestString(
//                            "Enter the product name to purchase",
//                            "The name cannot be empty."
//                        );
//                        int quantity = InputValidator.requestInteger(
//                            "Enter the quantity to purchase",
//                            "The quantity must be a valid integer."
//                        );
//                        inventory.purchaseProduct(purchaseName, quantity);
//                        InputValidator.showSuccessMessage("Purchase completed successfully.");
//                        break;
//
//                    case 4: // Statistics
//                        String statistics = inventory.getStatistics();
//                        InputValidator.showInfoMessage(statistics, "Statistics");
//                        break;
//
//                    case 5: // Search product
//                        String partialName = InputValidator.requestString(
//                            "Enter the name or part of the name of the product",
//                            "The name cannot be empty."
//                        );
//                        String result = inventory.searchProduct(partialName);
//                        InputValidator.showInfoMessage(result.isEmpty() ? "No products found." : result, "Search");
//                        break;
//
//                    case 6: // Exit
//                        String ticket = inventory.getFinalTicket();
//                        InputValidator.showInfoMessage(ticket, "Final Ticket");
//                        exit = true;
//                        break;
//
//                    default:
//                        JOptionPane.showMessageDialog(null, "Invalid option.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } catch (IllegalArgumentException e) {
//                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
        }
    }
}