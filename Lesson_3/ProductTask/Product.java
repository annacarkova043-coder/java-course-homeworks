public class Product { 
    private String name; 
    private String productionDate; 
    private String manufacturer; 
    private String country; 
    private double price; 
    private boolean inStock; 
 
    public Product(String name, String productionDate, String manufacturer, 
                   String country, double price, boolean inStock) { 
        this.name = name; 
        this.productionDate = productionDate; 
        this.manufacturer = manufacturer; 
        this.country = country; 
        this.price = price; 
        this.inStock = inStock; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public String getProductionDate() { 
        return productionDate; 
    } 
 
    public String getManufacturer() { 
        return manufacturer; 
    } 
 
    public String getCountry() { 
        return country; 
    } 
 
    public double getPrice() { 
        return price; 
    } 
 
    public boolean isInStock() { 
        return inStock; 
    } 
 
    public void displayInfo() { 
        System.out.println("Product: " + name); 
        System.out.println("Date: " + productionDate); 
        System.out.println("Manufacturer: " + manufacturer); 
        System.out.println("Country: " + country); 
        System.out.println("Price: $" + price); 
        System.out.println("In Stock: " + (inStock ? "Yes" : "No")); 
        System.out.println("--------------"); 
    } 
} 
