import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.print(item.getName() + "     " + item.getWeight() + "g" + "\n");
            totalWeight += item.getWeight();
        }

        System.out.println("Total package weight " + (totalWeight / 1000) + "kg");
    }
}