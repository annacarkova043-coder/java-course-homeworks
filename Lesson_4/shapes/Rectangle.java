package shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;
    private Color fillColor;
    private Color borderColor;
    
    // Constructor
    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        Shape.validatePositive(width, "Width");
        Shape.validatePositive(height, "Height");
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    
    // Constructor with default colors
    public Rectangle(double width, double height) {
        this(width, height, Color.WHITE, Color.BLACK);
    }
    
    // Constructor for square
    public Rectangle(double side, Color fillColor, Color borderColor) {
        this(side, side, fillColor, borderColor);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
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
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        Shape.validatePositive(width, "Width");
        this.width = width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        Shape.validatePositive(height, "Height");
        this.height = height;
    }
    
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    
    // Method to check if rectangle is a square
    public boolean isSquare() {
        return Math.abs(width - height) < 0.000001;
    }
    
    @Override
    public String toString() {
        String type = isSquare() ? "Square" : "Rectangle";
        return String.format("%s [width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f, fill=%s, border=%s]",
                type, width, height, calculateArea(), calculatePerimeter(), fillColor, borderColor);
    }
}