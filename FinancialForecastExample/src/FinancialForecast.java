public class FinancialForecast {

    // Recursive version
    public static double futureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        } else {
            return (1 + growthRate) * futureValueRecursive(currentValue, growthRate, years - 1);
        }
    }

    // Iterative version
    public static double futureValueIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    // Optimized version using Math.pow()
    public static double futureValueOptimized(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;  // Initial amount
        double growthRate = 0.05;      // 5% growth per year
        int years = 5;

        double resultRecursive = futureValueRecursive(currentValue, growthRate, years);
        System.out.printf("Recursive: Predicted Future Value after %d years: %.2f\n", years, resultRecursive);

        double resultIterative = futureValueIterative(currentValue, growthRate, years);
        System.out.printf("Iterative: Predicted Future Value after %d years: %.2f\n", years, resultIterative);

        double resultOptimized = futureValueOptimized(currentValue, growthRate, years);
        System.out.printf("Optimized (Math.pow): Predicted Future Value after %d years: %.2f\n", years, resultOptimized);
    }
}
