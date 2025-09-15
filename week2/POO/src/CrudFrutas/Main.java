package CrudFrutas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Fruit> fruits = new ArrayList<>();
    static int idFruit = 0;

    public static void main(String[] args) {
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
                    createFruit();
                    break;
                case "2":
                    listFruits();
                    break;
                case "3":
                    searchFruit();
                    break;
                case "4":
                    updateFruit();
                    break;
                case "5":
                    deleteFruit();
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

    private static void deleteFruit() {
    }

    private static void updateFruit() {
    }

    private static void searchFruit() {
    }

    private static void listFruits() {
        System.out.println("list");

        StringBuilder listFruits = new StringBuilder();

        for (Fruit fruit : fruits) {
            listFruits.append(fruit.toString());
        }

        JOptionPane.showMessageDialog(
                null,
                listFruits,
                "List Fruits",
                JOptionPane.PLAIN_MESSAGE);

    }

    private static void createFruit() {
        String name, color, origin;
        double weightKg, price;
        boolean isOrganic;

        name = JOptionPane.showInputDialog(null, "Name fruit ");
        color = JOptionPane.showInputDialog(null, "Color fruit ");
        origin = JOptionPane.showInputDialog(null, "Origin fruit ");
        weightKg = Double.parseDouble(JOptionPane.showInputDialog(null, "Weight fruit (Kg) "));
        price = Double.parseDouble(JOptionPane.showInputDialog(null, "Price fruit "));

        int r = JOptionPane.showConfirmDialog(null, "Is it Organic?");
        if (r == JOptionPane.YES_OPTION) {
            isOrganic=true;
        } else if (r == JOptionPane.NO_OPTION) {
            isOrganic=false;
        } else {
            return;
        }

        idFruit++;

        Fruit fruitUser = new Fruit(idFruit,name,color,origin,weightKg,price,isOrganic);
        fruits.add(new Fruit(idFruit,name,color,origin,weightKg,price,isOrganic));

    }
}
