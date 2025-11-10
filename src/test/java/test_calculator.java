import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import calculator.Calculator;

class TestCalculator {

    Calculator calculator; 

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test 
    void test_add() {
        int sum; 
        sum = calculator.add(3,2);
        assertEquals(sum, 5);
    }
    @Test 
    void test_divide() {
        double divide; 
        divide = calculator.divide(6,2);
        assertEquals(divide, 3);
    }
    @Test
    void test_generateRange() {
        int[] range;
        range = calculator.generateRange(5,10);
        int[] expected = {5,6,7,8,9,10};
        assertArrayEquals(range, expected);
    }
}

class TestCalculatorLogger {
    Calculator calculator;
    CalculatorLogger logger;

    @BeforeEach
    void test_add
}