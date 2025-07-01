public class Main {
    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        public int subtract(int a, int b) {
            return a - b;
        }
        public int multiply(int a, int b) {
            return a * b;
        }

        public int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    }
    public static void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);
        if (result == 7) {
            System.out.println("Test Add PASSED");
        } else {
            System.out.println("Test Add FAILED: expected 7 but got " + result);
        }
    }
    public static void testDivide() {
        Calculator calc = new Calculator();
        try {
            int result = calc.divide(10, 2);
            if (result == 5) {
                System.out.println("Test Divide PASSED");
            } else {
                System.out.println("Test Divide FAILED: expected 5 but got " + result);
            }
        } catch (ArithmeticException e) {
            System.out.println("Test Divide FAILED with exception: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        testAdd();
        testDivide();
        
    }
}
