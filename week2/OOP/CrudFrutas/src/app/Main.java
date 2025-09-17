package app;

import app.model.Fruit;
import app.service.FruitService;
import app.utils.InputValidator;

import javax.swing.*;
import java.lang.reflect.Type;
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
                    String name = InputValidator.requestString("Enter NAME: ");
                    String color = InputValidator.requestString("Enter COLOR");
                    String origin = InputValidator.requestString("Enter ORIGIN");
                    Optional<Double> weightKg = InputValidator.requestDouble("Enter WEIGHT (Kg)");
                    Optional<Double> price = InputValidator.requestDouble("Enter PRICE");

                    int r = JOptionPane.showConfirmDialog(null, "Is it Organic?");
                    boolean isOrganic;
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
                    String optionSearch = InputValidator.requestString("----- Search -----\n1. Using ID\n2. Using name");

                    switch (optionSearch){
                        case "1":
                            int idFruit = InputValidator.requestInteger("Enter ID to search");
                            fruit.searchFruit(idFruit);
                            break;
                        case "2":
                            String nameFruit = InputValidator.requestString("Enter name to search");
                            fruit.searchFruit(nameFruit);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Invalid Option","Warning",JOptionPane.WARNING_MESSAGE);
                            break;
                    }
                    break;
                case "4":
                    String fruticas = String.valueOf(fruit.showFruits());
                    int IdFruit = InputValidator.requestInteger(fruticas+"\n\nEnter ID fruit to update: ");

                    int attribute = InputValidator.requestInteger(
                            """
                            1. Name
                            2. Color
                            3. Origin
                            4. Weight
                            5. Price
                            6. Is Organic?
                            Choose an attribute to update""");


                    fruit.updateFruit(IdFruit, attribute);
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
