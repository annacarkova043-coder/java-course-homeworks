package animals;

public abstract class Animal {
    private String name;
    private static int animalCount = 0;
    
    // Constructor
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public static int getAnimalCount() {
        return animalCount;
    }
    
    // Abstract methods to be implemented by subclasses
    public abstract void run(int distance);
    public abstract void swim(int distance);
    
    // Get maximum running distance
    public abstract int getMaxRunDistance();
    
    // Get maximum swimming distance
    public abstract int getMaxSwimDistance();
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + name;
    }
}