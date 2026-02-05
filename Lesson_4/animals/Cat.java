package animals;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull; // satiety status
    
    // Constructor
    public Cat(String name) {
        super(name);
        this.isFull = false; // Cats are hungry when created
        catCount++;
    }
    
    // Get maximum running distance for cats
    @Override
    public int getMaxRunDistance() {
        return 200; // Cats can run up to 200 meters
    }
    
    // Get maximum swimming distance for cats
    @Override
    public int getMaxSwimDistance() {
        return 0; // Cats can't swim
    }
    
    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println(getName() + ": Distance must be positive!");
        } else if (distance <= getMaxRunDistance()) {
            System.out.println(getName() + " ran " + distance + " meters.");
        } else {
            System.out.println(getName() + " can't run " + distance + 
                             " meters. Maximum is " + getMaxRunDistance() + " meters.");
        }
    }
    
    @Override
    public void swim(int distance) {
        System.out.println(getName() + " can't swim!");
    }
    
    // Method for cat to eat from a bowl
    public void eatFromBowl(Bowl bowl, int amount) {
        if (bowl == null) {
            System.out.println(getName() + ": There is no bowl!");
            return;
        }
        
        if (amount <= 0) {
            System.out.println(getName() + ": Food amount must be positive!");
            return;
        }
        
        if (isFull) {
            System.out.println(getName() + " is already full and doesn't want to eat.");
            return;
        }
        
        if (bowl.decreaseFood(amount)) {
            isFull = true;
            System.out.println(getName() + " ate " + amount + " units of food and is now full.");
        } else {
            System.out.println(getName() + " didn't eat. Not enough food in the bowl.");
        }
    }
    
    // Method to feed a cat with a standard portion
    public void eatFromBowl(Bowl bowl) {
        eatFromBowl(bowl, 10); // Default portion size
    }
    
    // Getters and setters
    public boolean isFull() {
        return isFull;
    }
    
    public void setHungry() {
        this.isFull = false;
    }
    
    public static int getCatCount() {
        return catCount;
    }
}