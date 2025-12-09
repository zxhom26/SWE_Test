import java.util.ArrayList;
import java.util.List;

// Order class
public class Order {
    private ShoppingCart cart;
    private boolean isPaid = false;

    public Order(ShoppingCart cart) {
        this.cart = cart;
    }

    public void pay(double amount) {
        if(amount < cart.calculateTotal())
            throw new IllegalArgumentException("Insufficient payment");
        isPaid = true;
    }

    public boolean isPaid() { return isPaid; }

    public double getTotal() {
        return cart.calculateTotal();
    }
}