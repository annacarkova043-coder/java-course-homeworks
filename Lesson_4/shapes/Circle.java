package shapes;

public class Circle implements Shape {
    private double radius;
    private Color fillColor;
    private Color borderColor;
    
    // Constants
    public static final double PI = 3.141592653589793;
    
    // Constructor
    public Circle(double radius, Color fillColor, Color borderColor) {
        Shape.validatePositive(radius, "Radius");
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    
    // Constructor with default colors
    public Circle(double radius) {
        this(radius, Color.WHITE, Color.BLACK);
    }
    
    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
    
    @Override
    public Color getFillColor() {
        return fillColor;
    }
    
    @Override
    public Color getBorderColor() {
        return borderColor;
    }
    
    // Getters and setters
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        Shape.validatePositive(radius, "Radius");
        this.radius = radius;
    }
    
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    
    @Override
    public String toString() {
        return String.format("Circle [radius=%.2f, area=%.2f, perimeter=%.2f, fill=%s, border=%s]",
                radius, calculateArea(), calculatePerimeter(), fillColor, borderColor);
    }
}