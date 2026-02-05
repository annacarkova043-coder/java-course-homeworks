package shapes;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private Color fillColor;
    private Color borderColor;
    
    // Constructor
    public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
        validateTriangleSides(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    
    // Constructor with default colors
    public Triangle(double sideA, double sideB, double sideC) {
        this(sideA, sideB, sideC, Color.WHITE, Color.BLACK);
    }
    
    // Constructor for equilateral triangle
    public Triangle(double side, Color fillColor, Color borderColor) {
        this(side, side, side, fillColor, borderColor);
    }
    
    // Validate triangle inequality theorem
    private void validateTriangleSides(double a, double b, double c) {
        Shape.validatePositive(a, "Side A");
        Shape.validatePositive(b, "Side B");
        Shape.validatePositive(c, "Side C");
        
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException(
                String.format("Invalid triangle sides: %.2f, %.2f, %.2f. " +
                            "Sum of any two sides must be greater than the third side.", a, b, c));
        }
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
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
    public double getSideA() {
        return sideA;
    }
    
    public void setSideA(double sideA) {
        validateTriangleSides(sideA, sideB, sideC);
        this.sideA = sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public void setSideB(double sideB) {
        validateTriangleSides(sideA, sideB, sideC);
        this.sideB = sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
    
    public void setSideC(double sideC) {
        validateTriangleSides(sideA, sideB, sideC);
        this.sideC = sideC;
    }
    
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    
    // Method to check triangle type
    public String getTriangleType() {
        if (Math.abs(sideA - sideB) < 0.000001 && 
            Math.abs(sideB - sideC) < 0.000001) {
            return "Equilateral";
        } else if (Math.abs(sideA - sideB) < 0.000001 || 
                   Math.abs(sideA - sideC) < 0.000001 || 
                   Math.abs(sideB - sideC) < 0.000001) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
    
    // Method to check if triangle is right-angled
    public boolean isRightAngled() {
        double a2 = sideA * sideA;
        double b2 = sideB * sideB;
        double c2 = sideC * sideC;
        
        // Check Pythagorean theorem with tolerance
        return Math.abs(a2 + b2 - c2) < 0.000001 ||
               Math.abs(a2 + c2 - b2) < 0.000001 ||
               Math.abs(b2 + c2 - a2) < 0.000001;
    }
    
    @Override
    public String toString() {
        return String.format("Triangle [sides=(%.2f, %.2f, %.2f), type=%s, area=%.2f, perimeter=%.2f, fill=%s, border=%s]",
                sideA, sideB, sideC, getTriangleType(), calculateArea(), calculatePerimeter(), fillColor, borderColor);
    }
}