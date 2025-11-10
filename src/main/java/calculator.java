package utils;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero not allowed");
        }
        return (double) a / b;
    }

    public int[] generateRange(int start, int end) {
        if (end < start) throw new IllegalArgumentException("End must be >= start");
        int[] range = new int[end - start + 1];
        for (int i = 0; i < range.length; i++) {
            range[i] = start + i;
        }
        return range;
    }
}

public class CalculatorLogger {

    private Calculator calculator;
    private List<String> history;

    public CalculatorLogger(Calculator calculator) {
        this.calculator = calculator;
        this.history = new ArrayList<>();
    }

    public int add(int a, int b) {
        int result = calculator.add(a, b);
        history.add("Added " + a + " + " + b + " = " + result);
        return result;
    }

    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        history.add("Divided " + a + " / " + b + " = " + result);
        return result;
    }

    public List<String> getHistory() {
        return history;
    }

    public void clearHistory() {
        history.clear();
    }
}