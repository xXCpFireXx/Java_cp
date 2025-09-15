import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String nameFruit = "", colorFruit = "", flavorFruit = "", originFruit = "";
        double weightFruit = 0.0;
        int amountFruits = 0;

        Fruta fruitUser = new Fruta(nameFruit, colorFruit, flavorFruit, originFruit, weightFruit);

        List<Fruta> hamper = new ArrayList<>();

        amountFruits = Integer.parseInt(JOptionPane.showInputDialog(null,"How many fruits do you want to add into the hamper?: "));

        String listFruits = "";

        for (int i = 0; i < amountFruits; i++) {
            nameFruit = JOptionPane.showInputDialog(null, "Name fruit "+(i+1));
            colorFruit = JOptionPane.showInputDialog(null, "Color fruit "+(i+1));
            flavorFruit = JOptionPane.showInputDialog(null, "Flavor fruit "+(i+1));
            originFruit = JOptionPane.showInputDialog(null, "Origin fruit "+(i+1));
            weightFruit = Double.parseDouble(JOptionPane.showInputDialog(null, "Weight fruit "+(i+1)));

            hamper.add(new Fruta(nameFruit, colorFruit, flavorFruit, originFruit, weightFruit));
        }

        for (Fruta fruit : hamper){
            listFruits += "Name: "+fruit.name+"\nColor: "+fruit.color+"\nFlavor: "+fruit.flavor+"\nOrigin: "+fruit.origin+"\nWeight: "+fruit.weight+"\n--------------\n";
        }

        JOptionPane.showMessageDialog(
                null,
                listFruits,
                "List Fruits",
                JOptionPane.PLAIN_MESSAGE);
    }
}
