public class TV extends Product implements Shippable {
    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public boolean isShippable() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}
