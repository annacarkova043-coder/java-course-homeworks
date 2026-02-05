package shapes;

public interface Shape {
    // Abstract methods that must be implemented
    double calculateArea();
    Color getFillColor();
    Color getBorderColor();
    
    // Default method for perimeter (can be overridden if needed)
    default double calculatePerimeter() {
        return 0.0;
    }
    
    // Default method to display shape information
    default void displayInfo() {
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Fill Color: " + getFillColor());
        System.out.println("Border Color: " + getBorderColor());
        System.out.println("-----------------------------------");
    }
    
    // Static method to validate positive values
    static void validatePositive(double value, String parameterName) {
        if (value <= 0) {
            throw new IllegalArgumentException(parameterName + " must be positive! Got: " + value);
        }
    }
}