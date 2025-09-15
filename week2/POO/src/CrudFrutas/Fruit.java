package CrudFrutas;

public class Fruit {

    // Atributos
    private int id;
    private String name, color, origin;
    private double weightKg, price;
    private boolean isOrganic;

    // Constructor
    public Fruit(int id, String name, String color, String origin, double weightKg, double price, boolean isOrganic) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.origin = origin;
        this.weightKg = weightKg;
        this.price = price;
        this.isOrganic = isOrganic;
    }

    // Methods, getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }

    @Override
    public String toString() {
        return "---- "+ name +" ----" +'\n' +
                "ID: " + id +'\n' +
                "Color: " + color + '\n' +
                "Origin: " + origin + '\n' +
                "Weight: " + weightKg +" Kg" +'\n' +
                "Price: " + price + '\n' +
                "Is Organic? " + isOrganic +'\n';
    }
}
