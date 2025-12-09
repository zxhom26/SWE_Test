import java.util.ArrayList;
import java.util.List;

// ShoppingCart class
public class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double calculateTotal() {
        double total = 0;
        for(Product p : items) total += p.getPrice();
        return total;
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }
}