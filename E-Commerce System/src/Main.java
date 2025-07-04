import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ali", 500);

        Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(5), 400);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 3, LocalDate.now().plusDays(2), 700);
        TV tv = new TV("TV", 3000, 1, 8000);
        MobileCard mobileCard = new MobileCard("Mobile Card", 50, 10);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(mobileCard, 1);

        Checkout.process(customer, cart);
    }
}
