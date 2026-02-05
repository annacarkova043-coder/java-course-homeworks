package park;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractions;
    
    // Constructor
    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }
    
    // Inner class for attractions
    public class Attraction {
        private String name;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private double price;
        
        // Constructor
        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, double price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }
        
        // Getters
        public String getName() {
            return name;
        }
        
        public LocalTime getOpeningTime() {
            return openingTime;
        }
        
        public LocalTime getClosingTime() {
            return closingTime;
        }
        
        public double getPrice() {
            return price;
        }
        
        // Setters
        public void setName(String name) {
            this.name = name;
        }
        
        public void setOpeningTime(LocalTime openingTime) {
            this.openingTime = openingTime;
        }
        
        public void setClosingTime(LocalTime closingTime) {
            this.closingTime = closingTime;
        }
        
        public void setPrice(double price) {
            this.price = price;
        }
        
        // Method to check if attraction is open at given time
        public boolean isOpenAt(LocalTime time) {
            return !time.isBefore(openingTime) && !time.isAfter(closingTime);
        }
        
        // Method to get working hours
        public String getWorkingHours() {
            return openingTime.toString() + " - " + closingTime.toString();
        }
        
        @Override
        public String toString() {
            return "Attraction: " + name + 
                   ", Working Hours: " + getWorkingHours() + 
                   ", Price: $" + String.format("%.2f", price);
        }
    }
    
    // Park methods
    
    public void addAttraction(String name, LocalTime openingTime, LocalTime closingTime, double price) {
        Attraction attraction = new Attraction(name, openingTime, closingTime, price);
        attractions.add(attraction);
    }
    
    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }
    
    public void removeAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equals(name));
    }
    
    public List<Attraction> getAttractions() {
        return new ArrayList<>(attractions);
    }
    
    public List<Attraction> getOpenAttractions(LocalTime currentTime) {
        List<Attraction> openAttractions = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction.isOpenAt(currentTime)) {
                openAttractions.add(attraction);
            }
        }
        return openAttractions;
    }
    
    public double getTotalRevenue(int visitorsPerDay) {
        double total = 0;
        for (Attraction attraction : attractions) {
            total += attraction.getPrice() * visitorsPerDay;
        }
        return total;
    }
    
    public String getParkName() {
        return parkName;
    }
    
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
    
    public void displayAllAttractions() {
        System.out.println("=== " + parkName + " Attractions ===");
        if (attractions.isEmpty()) {
            System.out.println("No attractions available.");
        } else {
            for (int i = 0; i < attractions.size(); i++) {
                System.out.println((i + 1) + ". " + attractions.get(i));
            }
        }
    }
    
    public void displayOpenAttractions(LocalTime currentTime) {
        List<Attraction> openAttractions = getOpenAttractions(currentTime);
        System.out.println("=== Currently Open Attractions at " + currentTime + " ===");
        if (openAttractions.isEmpty()) {
            System.out.println("No attractions are currently open.");
        } else {
            for (int i = 0; i < openAttractions.size(); i++) {
                System.out.println((i + 1) + ". " + openAttractions.get(i));
            }
        }
    }
}