package animals;

public class Bowl {
    private int foodAmount;
    
    // Constructor
    public Bowl(int initialFood) {
        setFoodAmount(initialFood);
    }
    
    // Get current food amount
    public int getFoodAmount() {
        return foodAmount;
    }
    
    // Set food amount with validation
    public void setFoodAmount(int amount) {
        if (amount < 0) {
            System.out.println("Error: Food amount cannot be negative! Setting to 0.");
            this.foodAmount = 0;
        } else {
            this.foodAmount = amount;
        }
    }
    
    // Decrease food amount
    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Error: Cannot decrease by non-positive amount!");
            return false;
        }
        
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        } else {
            System.out.println("Not enough food in the bowl. Available: " + 
                             foodAmount + ", requested: " + amount);
            return false;
        }
    }
    
    // Add food to the bowl
    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Error: Cannot add non-positive amount of food!");
            return;
        }
        
        foodAmount += amount;
        System.out.println("Added " + amount + " units of food to the bowl.");
        System.out.println("Total food in bowl: " + foodAmount);
    }
    
    // Fill the bowl to a specific amount
    public void fillBowl(int targetAmount) {
        if (targetAmount <= foodAmount) {
            System.out.println("Bowl already has " + foodAmount + 
                             " units, which is more than or equal to " + targetAmount);
        } else {
            int amountToAdd = targetAmount - foodAmount;
            addFood(amountToAdd);
        }
    }
    
    @Override
    public String toString() {
        return "Bowl with " + foodAmount + " units of food";
    }
}