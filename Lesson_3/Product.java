import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isBooked;
    
    public Product(String name, LocalDate productionDate, String manufacturer, 
                   String countryOfOrigin, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isBooked = isBooked;
    }
    
    public void printInfo() {
        System.out.println("=== Product Information ===");
        System.out.println("Name: " + name);
        System.out.println("Production Date: " + productionDate);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Country of Origin: " + countryOfOrigin);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println("Booked by customer: " + (isBooked ? "Yes" : "No"));
        System.out.println("==========================");
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getProductionDate() {
        return productionDate;
    }
    
    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public boolean isBooked() {
        return isBooked;
    }
    
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}