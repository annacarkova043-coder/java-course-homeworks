package shapes;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GEOMETRIC SHAPES CALCULATOR ===\n");
        
        // Create shapes with different colors
        Circle circle = new Circle(5.0, Color.RED, Color.BLACK);
        Rectangle rectangle = new Rectangle(4.0, 6.0, Color.BLUE, Color.YELLOW);
        Rectangle square = new Rectangle(5.0, 5.0, Color.GREEN, Color.BLACK);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, Color.YELLOW, Color.RED);
        Triangle equilateralTriangle = new Triangle(6.0, Color.PURPLE, Color.WHITE);
        
        // Display information using default method from interface
        System.out.println("1. Displaying shape information using default displayInfo() method:");
        System.out.println("================================================================");
        circle.displayInfo();
        rectangle.displayInfo();
        square.displayInfo();
        triangle.displayInfo();
        equilateralTriangle.displayInfo();
        
        // Demonstrate direct method calls
        System.out.println("\n2. Direct method calls and additional information:");
        System.out.println("==================================================");
        
        System.out.println("Circle:");
        System.out.println("  Radius: " + circle.getRadius());
        System.out.println("  Area: " + String.format("%.2f", circle.calculateArea()));
        System.out.println("  Perimeter: " + String.format("%.2f", circle.calculatePerimeter()));
        System.out.println("  Fill Color: " + circle.getFillColor());
        System.out.println("  Border Color: " + circle.getBorderColor());
        
        System.out.println("\nRectangle:");
        System.out.println("  Width: " + rectangle.getWidth());
        System.out.println("  Height: " + rectangle.getHeight());
        System.out.println("  Is Square: " + rectangle.isSquare());
        System.out.println("  Area: " + String.format("%.2f", rectangle.calculateArea()));
        System.out.println("  Perimeter: " + String.format("%.2f", rectangle.calculatePerimeter()));
        
        System.out.println("\nTriangle:");
        System.out.println("  Sides: " + triangle.getSideA() + ", " + 
                         triangle.getSideB() + ", " + triangle.getSideC());
        System.out.println("  Type: " + triangle.getTriangleType());
        System.out.println("  Is Right-Angled: " + triangle.isRightAngled());
        System.out.println("  Area: " + String.format("%.2f", triangle.calculateArea()));
        System.out.println("  Perimeter: " + String.format("%.2f", triangle.calculatePerimeter()));
        
        // Test with array of shapes
        System.out.println("\n3. Processing shapes in an array:");
        System.out.println("==================================");
        
        Shape[] shapes = {
            new Circle(3.0, Color.PINK, Color.BLACK),
            new Rectangle(2.0, 7.0, Color.CYAN, Color.BROWN),
            new Triangle(5.0, 12.0, 13.0, Color.ORANGE, Color.GRAY),
            new Circle(7.5, Color.GREEN, Color.WHITE),
            new Rectangle(8.0, Color.BLUE, Color.YELLOW)  // Square
        };
        
        double totalArea = 0;
        double totalPerimeter = 0;
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\nShape " + (i + 1) + ": " + shapes[i].getClass().getSimpleName());
            System.out.println("  Area: " + String.format("%.2f", shapes[i].calculateArea()));
            System.out.println("  Perimeter: " + String.format("%.2f", shapes[i].calculatePerimeter()));
            System.out.println("  Fill Color: " + shapes[i].getFillColor());
            System.out.println("  Border Color: " + shapes[i].getBorderColor());
            
            totalArea += shapes[i].calculateArea();
            totalPerimeter += shapes[i].calculatePerimeter();
        }
        
        System.out.println("\nSummary:");
        System.out.println("  Total Area of all shapes: " + String.format("%.2f", totalArea));
        System.out.println("  Total Perimeter of all shapes: " + String.format("%.2f", totalPerimeter));
        
        // Demonstrate toString() method
        System.out.println("\n4. Using toString() method:");
        System.out.println("===========================");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
        System.out.println(triangle);
        
        // Test error handling
        System.out.println("\n5. Error handling examples:");
        System.out.println("===========================");
        
        try {
            Circle invalidCircle = new Circle(-5.0, Color.RED, Color.BLACK);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating circle: " + e.getMessage());
        }
        
        try {
            Triangle invalidTriangle = new Triangle(1.0, 2.0, 10.0, Color.RED, Color.BLUE);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating triangle: " + e.getMessage());
        }
        
        try {
            Rectangle invalidRectangle = new Rectangle(0, 5.0, Color.RED, Color.BLUE);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating rectangle: " + e.getMessage());
        }
        
        System.out.println("\n=== PROGRAM COMPLETED SUCCESSFULLY ===");
    }
}