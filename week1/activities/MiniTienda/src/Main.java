import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main {

    static ArrayList<String> nameProducts = new ArrayList<>();
    static double[] prices = new double[0];
    static HashMap<String, Integer> stock = new HashMap<>();
    private static double totalPurchases = 0;

    public static void main(String[] args) {
        int breakDoWhile = 0;
        do {
            String optionMenu = JOptionPane.showInputDialog(null,
                    """
                            1. Add product.
                            2. List inventory.
                            3. Purchase product.
                            4. Display statistics (cheapest and most expensive).
                            5. Search for product by name.
                            6. Exit with final receipt.""",
                    "Mini Tienda - Menu",
                    JOptionPane.PLAIN_MESSAGE);
            if (optionMenu == null){
                break;
            }

            switch (optionMenu){
                case "1":
                    createProduct();
                    System.out.println(nameProducts);
                    System.out.println(Arrays.toString(prices));
                    System.out.println(stock);
                    break;
                case "2":
                    listStock();
                    break;
                case "3":
                    buyProduct();
                    break;
                case "6":
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

    // Método utilitario para agregar producto
    public static void addProduct(String name, double price, int amount){
        nameProducts.add(name);
        expandPrices(price);
        stock.put(name,amount);
    }

    // Método utilitario para expandir el array de precios
    public static void expandPrices(double newPrice){
        double [] newArrayPrices = new double[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            newArrayPrices[i] = prices[i];
        }
        newArrayPrices[prices.length] = newPrice;
        prices = newArrayPrices;
    }

    // Método utilitario para encontrar índice de nombre en ArrayList
    public static int indexOfName(String name){
        for (int index = 0; index < nameProducts.size(); index++) {
            String nameProduct = nameProducts.get(index);
            if (nameProduct.equals(name)){
                return index;
            }
        }
        return -2;
    }

    public static void createProduct() {
        double priceProduct;
        int amountProduct;
// ----------------------------- Name --------------------------------
        String nameProduct = JOptionPane.showInputDialog(
                null,
                "Enter the product's name",
                "Product Name",
                JOptionPane.PLAIN_MESSAGE);

        if (nameProduct == null){
            return;
        }

        nameProduct = nameProduct.toLowerCase();

        // Verifica si lo ingresado esta vacio
        if (nameProduct.trim().isEmpty()){
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid product name",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si ya existe (no duplicados)
        if (indexOfName(nameProduct)!=-2){
            JOptionPane.showMessageDialog(
                    null,
                    "Product already exits",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
// ---------------------------- Price -----------------------------------
        try{
            priceProduct = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            null,
                            "Enter " + nameProduct.toUpperCase() + " price",
                            nameProduct.toUpperCase() + " Price",
                            JOptionPane.PLAIN_MESSAGE));

            if (priceProduct<=0){
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
        }
// -------------------------- Amount --------------------------------------
        try {
            amountProduct = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            null,
                            "Enter " + nameProduct.toUpperCase() + " amount",
                            nameProduct.toUpperCase() + " Amount",
                            JOptionPane.PLAIN_MESSAGE));

            if (amountProduct<0){
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
        }
// --------------------- Add product ---------------------------
        addProduct(nameProduct, priceProduct, amountProduct);
        JOptionPane.showMessageDialog(
                null,
                "Product added successful",
                "Successful",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void listStock(){
        if (nameProducts.isEmpty()){
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

            listProducts += "PRODUCT: "+nameProduct.toUpperCase() + "\nPRICE: $"+priceProduct + "\nSTOCK: "+stockProduct+"\n-------------------------\n";
        }
        JOptionPane.showMessageDialog(
                null,
                listProducts,
                "List Products",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void buyProduct(){
        int amountProduct;

        if (nameProducts.isEmpty()){
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

        if (nameProduct == null){
            return;
        }
        nameProduct = nameProduct.toLowerCase();

        // Verifica si lo ingresado esta vacio
        if (nameProduct.trim().isEmpty()){
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid product name",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si hay producto
        if (indexOfName(nameProduct)==-2){
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
                             nameProduct.toUpperCase()+" STOCK: "+ currentStock +"\nEnter " + nameProduct.toUpperCase() + " amount to buy",
                            nameProduct.toUpperCase() + " Amount",
                            JOptionPane.PLAIN_MESSAGE));

            if (amountProduct<0){
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
        }
// --------------------- Stock product ---------------------------

        if (amountProduct>currentStock){
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
                "Do you want to buy " + amountProduct + " units of " + nameProduct + " for $" + (prices[indexOfName(nameProduct)] * amountProduct) + "?",
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





// Final clase
}



