public class FactorialCalculator {
    
    /**
     * Calculates factorial of a non-negative integer
     * @param n non-negative integer
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);
        }
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculates factorial using recursion
     * @param n non-negative integer
     * @return factorial of n
     */
    public static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);
        }
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        return n * factorialRecursive(n - 1);
    }
    
    /**
     * Checks if factorial calculation will overflow long type
     * @param n integer to check
     * @return true if factorial(n) fits in long, false otherwise
     */
    public static boolean isFactorialSafe(int n) {
        if (n < 0) return false;
        
        // Maximum n for which factorial fits in long (20! is the max)
        return n <= 20;
    }
}