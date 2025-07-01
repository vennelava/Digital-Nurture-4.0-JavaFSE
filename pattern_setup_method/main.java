public class main {
    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        test.setUp();
        test.testAdd();
        test.tearDown();
        test.setUp();
        test.testSubtract();
        test.tearDown();
    }
}
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
}
class CalculatorTest {
    Calculator calculator;
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created.");
    }
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance destroyed.\n");
    }
    public void testAdd() {
        int a = 5;
        int b = 3;
        int result = calculator.add(a, b);
        if (result == 8) {
            System.out.println("test Add PASSED");
        } else {
            System.out.println("test Add FAILED: expected 8 but got " + result);
        }
    }
    public void testSubtract() {
        int a = 10;
        int b = 4;

        int result = calculator.subtract(a, b);

        if (result == 6) {
            System.out.println("test Subtract PASSED");
        } else {
            System.out.println("test Subtract FAILED: expected 6 but got " + result);
        }
    }
}
