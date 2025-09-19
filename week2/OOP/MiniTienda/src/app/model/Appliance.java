package app.model;

public class Appliance extends Product{
    public Appliance(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "Appliances are durable household devices\nthat assist with daily tasks,\noften requiring electricity or gas.";
    }
}
