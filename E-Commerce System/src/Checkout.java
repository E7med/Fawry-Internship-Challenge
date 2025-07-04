import java.util.List;
import java.util.ArrayList;

public class Checkout {
    public static void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        List<Shippable> shippingItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();

            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired.");
                return;
            }

            if (item.getQuantity() > p.getQuantity()) {
                System.out.println("Error: Not enough quantity for " + p.getName());
                return;
            }

            if (p instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippingItems.add((Shippable) p);
                }
            }
        }

        double subtotal = cart.getSubtotal();
        double shipping = shippingItems.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // Shipping
        if (!shippingItems.isEmpty()) {
            ShippingService.ship(shippingItems);
        }


        customer.deduct(total);
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println();

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            String line = item.getQuantity() + "x " + item.getProduct().getName() + "\t\t" +
                     item.getTotalPrice();
            System.out.println(line);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal" + "     " + subtotal);
        System.out.println("Shipping" + "     " +  shipping);
        System.out.println("Amount" + "       " +  total);
        System.out.println("Remaining Balance" + "     " +  customer.getBalance());
    }
}
