package app.model;

public class Food extends Product{
    public Food(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "Food products are perishable\nitems meant for consumption, with expiration\ndates and specific storage needs.";
    }
}
