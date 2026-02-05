package animals;

public class Dog extends Animal {
    private static int dogCount = 0;
    
    // Constructor
    public Dog(String name) {
        super(name);
        dogCount++;
    }
    
    // Get maximum running distance for dogs
    @Override
    public int getMaxRunDistance() {
        return 500; // Dogs can run up to 500 meters
    }
    
    // Get maximum swimming distance for dogs
    @Override
    public int getMaxSwimDistance() {
        return 10; // Dogs can swim up to 10 meters
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
        if (distance <= 0) {
            System.out.println(getName() + ": Distance must be positive!");
        } else if (distance <= getMaxSwimDistance()) {
            System.out.println(getName() + " swam " + distance + " meters.");
        } else {
            System.out.println(getName() + " can't swim " + distance + 
                             " meters. Maximum is " + getMaxSwimDistance() + " meters.");
        }
    }
    
    public static int getDogCount() {
        return dogCount;
    }
}