public class Main { 
    public static void main(String[] args) { 
        System.out.println("=== TESTING 'PRODUCT' CLASS ===\\n"); 
 
        Product product1 = new Product("iPhone 15 Pro Smartphone", "2023-09-20", "Apple Inc.", "USA", 129999.99, true); 
        System.out.println("Product 1 - Smartphone:"); 
        product1.printInfo(); 
 
        Product product2 = new Product("Lenovo ThinkPad Laptop", "2024-01-15", "Lenovo Group", "China", 89999.50, false); 
        System.out.println("\\nProduct 2 - Laptop:"); 
        product2.printInfo(); 
 
        Product product3 = new Product("Sony WH-1000XM5 Headphones", "2023-11-10", "Sony Corporation", "Japan", 34999.00, true); 
        System.out.println("\\nProduct 3 - Headphones:"); 
        product3.printInfo(); 
 
        Product product4 = new Product("CASIO G-Shock Watch", "2024-02-01", "Casio Computer Co.", "Japan", 15999.99, false); 
        System.out.println("\\nProduct 4 - Watch:"); 
        product4.printInfo(); 
 
        System.out.println("\\n=== ADDITIONAL INFORMATION ==="); 
        System.out.println("Most expensive product: " + product1.getName() + " (" + product1.getPrice() + " RUB)"); 
        System.out.println("Watch manufacturer: " + product4.getManufacturer()); 
        System.out.println("Laptop production country: " + product2.getCountryOfOrigin()); 
 
        System.out.println("\\n=== RESERVATION STATUS ==="); 
        System.out.println("Smartphone reserved: " + (product1.isReserved() ? "Yes" : "No")); 
        System.out.println("Laptop reserved: " + (product2.isReserved() ? "Yes" : "No")); 
        System.out.println("Headphones reserved: " + (product3.isReserved() ? "Yes" : "No")); 
        System.out.println("Watch reserved: " + (product4.isReserved() ? "Yes" : "No")); 
    } 
} 
