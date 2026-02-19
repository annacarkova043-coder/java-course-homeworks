public class NumberComparator {
    
    /**
     * Compares two integers
     * @param a first number
     * @param b second number
     * @return 1 if a > b, -1 if a < b, 0 if a == b
     */
    public static int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * Returns the maximum of two numbers
     * @param a first number
     * @param b second number
     * @return maximum of a and b
     */
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    /**
     * Returns the minimum of two numbers
     * @param a first number
     * @param b second number
     * @return minimum of a and b
     */
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }
    
    /**
     * Checks if numbers are equal
     * @param a first number
     * @param b second number
     * @return true if equal
     */
    public static boolean isEqual(int a, int b) {
        return a == b;
    }
    
    /**
     * Checks if first number is greater than second
     * @param a first number
     * @param b second number
     * @return true if a > b
     */
    public static boolean isGreater(int a, int b) {
        return a > b;
    }
    
    /**
     * Checks if first number is less than second
     * @param a first number
     * @param b second number
     * @return true if a < b
     */
    public static boolean isLess(int a, int b) {
        return a < b;
    }
    
    /**
     * Checks if number is within range [min, max] inclusive
     * @param number number to check
     * @param min minimum value
     * @param max maximum value
     * @return true if number is in range
     */
    public static boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }
}