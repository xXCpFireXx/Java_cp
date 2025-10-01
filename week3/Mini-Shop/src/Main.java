import Controller.ProductController;
import Utils.InputCheck;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        String option = "";
        do {
            option = JOptionPane.showInputDialog(
                    null,
                    """
                            1. Add product.
                            2. List inventory.
                            3. Update price.
                            4. Update stock.
                            5. Delete product.
                            6. Search for product by name.
                            7. Exit with summary (number of operations done)""".toUpperCase(),
                    "Mini Shop - Menu".toUpperCase(),
                    JOptionPane.QUESTION_MESSAGE);
            switch (option){
                case "1":
                    ProductController.create();
                    break;
                case "2":
                    ProductController.getAll();
                    break;
                case "3":
                    ProductController.update(3);
                    break;
                case "4":
                    ProductController.update(4);
                    break;
                case "5":
                    ProductController.delete();
                    break;
                case "6":
                    ProductController.search();
                    break;
                case "7":
                    ProductController.exit();
                    break;
                default:
                    InputCheck.showWarningMessage("Invalid option","Error");
                    break;
            }
        }while (!option.equals("7"));


    }
}