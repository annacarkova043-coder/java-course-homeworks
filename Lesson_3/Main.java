import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product(
            "Fresh Milk",
            LocalDate.of(2024, 3, 15),
            "DairyFarm Inc.",
            "USA",
            2.99,
            false
        );
        
        Product bread = new Product(
            "Whole Wheat Bread",
            LocalDate.of(2024, 3, 16),
            "Bakery Co.",
            "France",
            3.49,
            true
        );
        
        Product chocolate = new Product(
            "Dark Chocolate",
            LocalDate.of(2024, 2, 28),
            "SweetTreats Ltd.",
            "Switzerland",
            4.99,
            false
        );
        
        Product oliveOil = new Product(
            "Extra Virgin Olive Oil",
            LocalDate.of(2024, 1, 10),
            "Mediterranean Foods",
            "Italy",
            12.99,
            true
        );
        
        System.out.println("Food Products in Store:\n");
        
        milk.printInfo();
        bread.printInfo();
        chocolate.printInfo();
        oliveOil.printInfo();
        
        System.out.println("\n=== Additional Information ===");
        System.out.println("Most expensive product: " + oliveOil.getName());
        System.out.println("Price: $" + oliveOil.getPrice());
        
        System.out.println("\n=== Changing Booking Status ===");
        System.out.println("Milk booked status before: " + milk.isBooked());
        milk.setBooked(true);
        System.out.println("Milk booked status after: " + milk.isBooked());
        milk.printInfo();
    }
}