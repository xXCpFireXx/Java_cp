package app.service;

import app.model.Fruit;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FruitService {
    List<Fruit> fruits = new ArrayList<>();
    int idFruit = 0;

    public void deleteFruit() {
    }

    public void updateFruit(int IdFruit, int attribute) {

        for (Fruit currentFruit : fruits) {
            if (currentFruit.getId() == IdFruit) {
                switch (attribute){
                    case 1:

                        currentFruit.setName("");

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }
        }

    }

    public void searchFruit(String nameFruit) {
        StringBuilder searchFruit = new StringBuilder();
        for (Fruit currentFruit : fruits) {
            if (currentFruit.getName().contains(nameFruit.toLowerCase())) {
                searchFruit.append(currentFruit);
            }
        }
        JOptionPane.showMessageDialog(null, searchFruit);
    }

    public void searchFruit(int IDFruit) {
        StringBuilder searchFruit = new StringBuilder();
        for (Fruit currentFruit : fruits) {
            if (currentFruit.getId() == IDFruit) {
                searchFruit.append(currentFruit);
            }
        }
        JOptionPane.showMessageDialog(null, searchFruit);
    }



    public void listFruits() {
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

    public void createFruit( String name, String color, String origin, double weightKg, double price, boolean isOrganic) {
        idFruit++;
        fruits.add(new Fruit(idFruit,name,color,origin,weightKg,price,isOrganic));
    }

    public StringBuilder showFruits(){
        StringBuilder fruitsNameId = new StringBuilder();
        for (Fruit f : fruits){
            if (f==null){
                fruitsNameId.append("No found fruits");
            } else {
                fruitsNameId.append("ID: ").append(f.getId()).append(" -> ").append(f.getName()).append("\n");
            }
        }
        return fruitsNameId;
    }
}
