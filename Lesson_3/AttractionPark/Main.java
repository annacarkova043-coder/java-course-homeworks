import park.Park;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create a park
        Park adventurePark = new Park("Adventure World");
        
        // Add attractions using the inner class
        Park.Attraction rollerCoaster = adventurePark.new Attraction(
            "Thunder Roller Coaster",
            LocalTime.of(10, 0),  // 10:00 AM
            LocalTime.of(20, 0),  // 8:00 PM
            15.99
        );
        
        Park.Attraction ferrisWheel = adventurePark.new Attraction(
            "Sky Wheel",
            LocalTime.of(11, 0),  // 11:00 AM
            LocalTime.of(22, 0),  // 10:00 PM
            8.50
        );
        
        Park.Attraction waterSlide = adventurePark.new Attraction(
            "Aqua Adventure",
            LocalTime.of(9, 30),  // 9:30 AM
            LocalTime.of(18, 30), // 6:30 PM
            12.75
        );
        
        // Add attractions to the park
        adventurePark.addAttraction(rollerCoaster);
        adventurePark.addAttraction(ferrisWheel);
        adventurePark.addAttraction(waterSlide);
        
        // Add another attraction using the convenience method
        adventurePark.addAttraction(
            "Haunted House",
            LocalTime.of(12, 0),  // 12:00 PM
            LocalTime.of(23, 0),  // 11:00 PM
            10.25
        );
        
        // Display all attractions
        adventurePark.displayAllAttractions();
        System.out.println();
        
        // Check which attractions are open at different times
        LocalTime afternoon = LocalTime.of(14, 30); // 2:30 PM
        adventurePark.displayOpenAttractions(afternoon);
        System.out.println();
        
        LocalTime evening = LocalTime.of(21, 0); // 9:00 PM
        adventurePark.displayOpenAttractions(evening);
        System.out.println();
        
        // Calculate potential revenue
        int estimatedVisitors = 500;
        double estimatedRevenue = adventurePark.getTotalRevenue(estimatedVisitors);
        System.out.println("Estimated daily revenue with " + estimatedVisitors + 
                         " visitors: $" + String.format("%.2f", estimatedRevenue));
        System.out.println();
        
        // Demonstrate individual attraction methods
        System.out.println("=== Individual Attraction Details ===");
        System.out.println("Roller Coaster working hours: " + rollerCoaster.getWorkingHours());
        System.out.println("Is Roller Coaster open at 19:00? " + 
                          rollerCoaster.isOpenAt(LocalTime.of(19, 0)));
        System.out.println("Is Ferris Wheel open at 23:00? " + 
                          ferrisWheel.isOpenAt(LocalTime.of(23, 0)));
        
        // Update an attraction's price
        System.out.println("\n=== Price Update ===");
        System.out.println("Old price for Water Slide: $" + waterSlide.getPrice());
        waterSlide.setPrice(14.99);
        System.out.println("New price for Water Slide: $" + waterSlide.getPrice());
        
        // Remove an attraction
        System.out.println("\n=== Removing an Attraction ===");
        adventurePark.removeAttraction("Haunted House");
        System.out.println("After removing Haunted House:");
        adventurePark.displayAllAttractions();
    }
}