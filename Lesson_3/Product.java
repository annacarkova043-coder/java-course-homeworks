public class Product { 
    private String name; 
    private String productionDate; 
    private String manufacturer; 
    private String countryOfOrigin; 
    private double price; 
    private boolean isReserved; 
 
    public Product(String name, String productionDate, String manufacturer, 
                   String countryOfOrigin, double price, boolean isReserved) { 
        this.name = name; 
        this.productionDate = productionDate; 
        this.manufacturer = manufacturer; 
        this.countryOfOrigin = countryOfOrigin; 
        this.price = price; 
        this.isReserved = isReserved; 
    } 
 
    public void printInfo() { 
        System.out.println("=== PRODUCT INFORMATION ==="); 
        System.out.println("Name: " + name); 
        System.out.println("Production date: " + productionDate); 
        System.out.println("Manufacturer: " + manufacturer); 
        System.out.println("Country of origin: " + countryOfOrigin); 
        System.out.println("Price: " + price + " RUB"); 
        System.out.println("Reservation status: " + (isReserved ? "Reserved" : "Available")); 
        System.out.println("=========================="); 
    } 
 
    public String getName() { return name; } 
    public String getProductionDate() { return productionDate; } 
    public String getManufacturer() { return manufacturer; } 
    public String getCountryOfOrigin() { return countryOfOrigin; } 
    public double getPrice() { return price; } 
    public boolean isReserved() { return isReserved; } 
} 
