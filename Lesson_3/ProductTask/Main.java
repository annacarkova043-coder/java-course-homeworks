public class Main {
    public static void main(String[] args) {
        
        Product[] productsArray = new Product[5];
        
        
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                                      "Samsung Corp.", "Korea", 5599, true);
        
        productsArray[1] = new Product("iPhone 16 Pro", "15.09.2024",
                                      "Apple Inc.", "USA", 4899, true);
        
        productsArray[2] = new Product("Xiaomi 14 Pro", "10.11.2024",
                                      "Xiaomi Corp.", "China", 3299, false);
        
        productsArray[3] = new Product("Google Pixel 9", "05.10.2024",
                                      "Google LLC", "USA", 2799, true);
        
        productsArray[4] = new Product("OnePlus 12", "20.12.2024",
                                      "OnePlus Tech", "China", 2599, true);
        
        
        System.out.println("=== Product Catalog ===\n");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Product #" + (i + 1) + ":");
            productsArray[i].displayInfo();
        }
        
        
        System.out.println("\n=== Additional Operations ===");
        
        
        int inStockCount = 0;
        for (Product product : productsArray) {
            if (product.isInStock()) {
                inStockCount++;
            }
        }
        System.out.println("Products in stock: " + inStockCount + " of " + productsArray.length);
        
        
        double totalPrice = 0;
        for (Product product : productsArray) {
            totalPrice += product.getPrice();
        }
        double averagePrice = totalPrice / productsArray.length;
        System.out.println("Average price: $" + String.format("%.2f", averagePrice));
        
        
        Product mostExpensive = productsArray[0];
        for (int i = 1; i < productsArray.length; i++) {
            if (productsArray[i].getPrice() > mostExpensive.getPrice()) {
                mostExpensive = productsArray[i];
            }
        }
        System.out.println("Most expensive product: " + mostExpensive.getName() + 
                          " ($" + mostExpensive.getPrice() + ")");
    }
}