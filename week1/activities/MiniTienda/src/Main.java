import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main {

    static ArrayList<String> nameProducts = new ArrayList<>();
    static double[] prices = new double[0];
    static HashMap<String, Integer> stock = new HashMap<>();

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

            switch (optionMenu){
                case "1":
                    createProduct();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid option",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    break;
            }

        } while (breakDoWhile != 6);
    }

    public static void addProduct(String name, double price, int amount){
        nameProducts.add(name);
        prices = expandPrices(prices);
        prices[prices.length-1] = price;
        stock.put(name,amount);
    }

    static double[] expandPrices(double[] pricesArray){
        double [] newArrayPrices = new double[pricesArray.length + 1];

        for (int i = 0; i < pricesArray.length+1; i++) {
            newArrayPrices[i] = pricesArray[i];
        }
        return newArrayPrices;
    }

    static int indexOfName(String name){

        for (int index = 0; index < nameProducts.size(); index++) {
            if (nameProducts.get(index).equals(name)){
                return index;
            }
        }

        return -1;
    }

    static void createProduct() {
        String nameProduct = "";
        double priceProduct = 0;
        int amountProduct = 0;

        try {
        nameProduct = JOptionPane.showInputDialog(
                null,
                "Enter a product name",
                "Product Name",
                JOptionPane.PLAIN_MESSAGE).toLowerCase();

        if (indexOfName(nameProduct)!=-1){
            JOptionPane.showMessageDialog(null,"Product exits");
            return;
        }


            priceProduct = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            null,
                            "Enter " + nameProduct.toUpperCase() + " price",
                            nameProduct.toUpperCase() + " Price",
                            JOptionPane.PLAIN_MESSAGE));

            amountProduct = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            null,
                            "Enter " + nameProduct.toUpperCase() + " amount",
                            nameProduct.toUpperCase() + " Amount",
                            JOptionPane.PLAIN_MESSAGE));

            System.out.println(nameProduct);
            System.out.println(priceProduct);
            System.out.println(amountProduct);
            addProduct(nameProduct, priceProduct, amountProduct);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Enter a number","Error",JOptionPane.WARNING_MESSAGE);
        }



    }
}
