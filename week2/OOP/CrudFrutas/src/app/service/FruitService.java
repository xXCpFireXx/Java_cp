package app.service;

import app.model.Fruit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FruitService {
    List<Fruit> fruits = new ArrayList<>();
    int idFruit = 0;

    public void deleteFruit() {
    }

    public void updateFruit() {
    }

    public void searchFruit() {
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
}
