import org.junit.jupiter.api.Test;               // For @Test annotation
import org.junit.jupiter.api.BeforeEach;         // For setup before each test
import org.junit.jupiter.api.AfterEach;          // Optional, cleanup after each test
import static org.junit.jupiter.api.Assertions.*; // For assertions (assertEquals, assertThrows, etc.)

import java.util.ArrayList;
import java.util.List;

import src.main.java.*; 

public class TestOrder {

    Order order;
    ShoppingCart cart;
    Product product;
    Product product2;

    @BeforeEach
    public void setUp() {
        product = new Product("1234", "Dildo", 42.0);
        product2 = new Product("4321", "Lube", 0.67);
        cart = new ShoppingCart();
        cart.addItem(product);
        cart.addItem(product2);
        order = new Order(cart);
    }
    @Test
    public void testPayThrowException() {
        assertThrows(IllegalArgumentException, () -> order.pay(2.0));
    }
    @Test
    public void testIsPaid() {
        order.pay(100);
        assertEquals(true, order.isPaid());
    }
    @Test
    public void testGetTotal() {
        double total = order.getTotal();
        assertEquals(42.67, total);
    }

}