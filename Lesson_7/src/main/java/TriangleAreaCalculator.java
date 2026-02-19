public class TriangleAreaCalculator {
    
    /**
     * Calculates area of triangle using base and height
     * @param base base length (positive)
     * @param height height length (positive)
     * @return area of triangle
     * @throws IllegalArgumentException if base or height is not positive
     */
    public static double areaByBaseAndHeight(double base, double height) {
        validatePositive(base, "Base");
        validatePositive(height, "Height");
        
        return 0.5 * base * height;
    }
    
    /**
     * Calculates area of triangle using three sides (Heron's formula)
     * @param a side a (positive)
     * @param b side b (positive)
     * @param c side c (positive)
     * @return area of triangle
     * @throws IllegalArgumentException if sides are invalid or don't form a triangle
     */
    public static double areaByThreeSides(double a, double b, double c) {
        validatePositive(a, "Side a");
        validatePositive(b, "Side b");
        validatePositive(c, "Side c");
        
        // Check triangle inequality theorem
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException(
                String.format("Invalid triangle sides: %.2f, %.2f, %.2f. Sum of any two sides must be greater than the third.", 
                a, b, c));
        }
        
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    /**
     * Calculates area of right triangle
     * @param leg1 first leg (positive)
     * @param leg2 second leg (positive)
     * @return area of right triangle
     */
    public static double areaOfRightTriangle(double leg1, double leg2) {
        validatePositive(leg1, "Leg1");
        validatePositive(leg2, "Leg2");
        
        return 0.5 * leg1 * leg2;
    }
    
    /**
     * Calculates area of equilateral triangle
     * @param side side length (positive)
     * @return area of equilateral triangle
     */
    public static double areaOfEquilateralTriangle(double side) {
        validatePositive(side, "Side");
        
        return (Math.sqrt(3) / 4) * side * side;
    }
    
    private static void validatePositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be positive. Got: " + value);
        }
    }
}