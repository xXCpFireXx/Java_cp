import javax.swing.*;

public class Fruta {
    String name;
    String color;
    String flavor;
    String origin;
    double weight;

    public Fruta(String name, String color, String flavor, String origin, double weight) {
        this.name = name;
        this.color = color;
        this.flavor = flavor;
        this.origin = origin;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void ripen(){
        JOptionPane.showMessageDialog(null, "Ya ha madurado");
    }

    public void spoil(){
        JOptionPane.showMessageDialog(null,"Se ha pudrido la fruta");
    }

}
