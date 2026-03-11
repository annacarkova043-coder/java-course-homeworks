public class ArithmeticOperations {
    
    /**
     * Adds two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtracts two numbers (a - b)
     * @param a first number
     * @param b second number
     * @return result of a - b
     */
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divides two numbers (a / b)
     * @param a dividend
     * @param b divisor (cannot be zero)
     * @return result of a / b
     * @throws ArithmeticException if b is zero
     */
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
    
    /**
     * Calculates a to the power of b
     * @param a base
     * @param b exponent (non-negative)
     * @return a raised to power b
     * @throws IllegalArgumentException if b is negative
     */
    public static long power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative: " + b);
        }
        
        if (b == 0) {
            return 1;
        }
        
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
    
    /**
     * Calculates modulo (remainder of division)
     * @param a dividend
     * @param b divisor (cannot be zero)
     * @return a % b
     */
    public static int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed");
        }
        return a % b;
    }
    
    /**
     * Checks if a number is even
     * @param a number to check
     * @return true if a is even
     */
    public static boolean isEven(int a) {
        return a % 2 == 0;
    }
    
    /**
     * Checks if a number is odd
     * @param a number to check
     * @return true if a is odd
     */
    public static boolean isOdd(int a) {
        return a % 2 != 0;
    }
}