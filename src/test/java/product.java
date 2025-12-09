import org.junit.jupiter.api.Test;               // For @Test annotation
import org.junit.jupiter.api.BeforeEach;         // For setup before each test
import org.junit.jupiter.api.AfterEach;          // Optional, cleanup after each test
import static org.junit.jupiter.api.Assertions.*; // For assertions (assertEquals, assertThrows, etc.)

import java.util.ArrayList;
import java.util.List;

import src.main.java.*; 

public class TestProduct {
    Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("1234", "Zach", 69.0);
    }

    @Test
    public void testGetPrice() {
        double price;
        price = product.getPrice();
        assertEquals(69.0, price);
    }

    @Test
    public void testGetName() {
        String name;
        name = product.getName();
        assertEquals("Zach", name);
    }

    @Test
    public void testGetId() {
        String id;
        id = product.getId();
        assertEquals("1234", id);
    }
}