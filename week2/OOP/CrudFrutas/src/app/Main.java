package app;

import app.model.Fruit;
import app.service.FruitService;
import app.utils.InputValidator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        FruitService fruit = new FruitService();

        int stopper = 0;

        do {
            // Menu options
            String optionMenu = JOptionPane.showInputDialog(
                    null,
                    """
                            1. Create fruit.
                            2. List all fruits.
                            3. Search fruit.
                            4. Update fruit.
                            5. Delete fruit.
                            6. Exit""",
                    "Fruitys - Menu",
                    JOptionPane.PLAIN_MESSAGE);

            if (optionMenu == null) {
                break;
            }

            switch (optionMenu) {
                case "1":

                    String name, color, origin;
                    Optional<Double> weightKg;
                    Optional<Double> price;
                    boolean isOrganic;

                    name = InputValidator.requestString("Enter NAME: ");
                    color = InputValidator.requestString("Enter COLOR");
                    origin = InputValidator.requestString("Enter ORIGIN");
                    weightKg = InputValidator.requestDouble("Enter WEIGHT (Kg)");
                    price = InputValidator.requestDouble("Enter PRICE");


                    int r = JOptionPane.showConfirmDialog(null, "Is it Organic?");
                    if (r == JOptionPane.YES_OPTION) {
                        isOrganic=true;
                    } else if (r == JOptionPane.NO_OPTION) {
                        isOrganic=false;
                    } else {
                        return;
                    }

                    fruit.createFruit(name,color,origin,weightKg.get(),price.get(),isOrganic);
                    break;
                case "2":
                    fruit.listFruits();
                    break;
                case "3":
                    fruit.searchFruit();
                    break;
                case "4":
                    fruit.updateFruit();
                    break;
                case "5":
                    fruit.deleteFruit();
                    break;
                case "6":
                    stopper = 6;
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid option",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }

        }while (stopper!=6);


    }


}
