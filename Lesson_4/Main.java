import animals.Animal;
import animals.Dog;
import animals.Cat;
import animals.Bowl;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ANIMAL TESTING ===");
        
        // Create animals
        Dog dog1 = new Dog("Bobik");
        Dog dog2 = new Dog("Rex");
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Murzik");
        Cat cat3 = new Cat("Vasya");
        
        // Test running
        System.out.println("\n--- Testing running ---");
        dog1.run(150);
        dog1.run(600);
        dog2.run(450);
        cat1.run(100);
        cat1.run(250);
        cat2.run(50);
        
        // Test swimming
        System.out.println("\n--- Testing swimming ---");
        dog1.swim(5);
        dog1.swim(15);
        cat1.swim(5);
        cat2.swim(1);
        
        // Display animal counts
        System.out.println("\n--- Animal Statistics ---");
        System.out.println("Total animals created: " + Animal.getAnimalCount());
        System.out.println("Total dogs created: " + Dog.getDogCount());
        System.out.println("Total cats created: " + Cat.getCatCount());
        
        System.out.println("\n=== FEEDING CATS FROM BOWL ===");
        
        // Create a bowl with some food
        Bowl bowl = new Bowl(25);
        System.out.println("Initial state: " + bowl);
        
        // Create an array of cats
        Cat[] cats = {
            new Cat("Whiskers"),
            new Cat("Mittens"),
            new Cat("Shadow"),
            new Cat("Luna"),
            new Cat("Simba")
        };
        
        // Try to feed all cats
        System.out.println("\n--- First feeding attempt ---");
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
        }
        
        // Display satiety status
        System.out.println("\n--- Satiety status after first attempt ---");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " is full: " + cat.isFull());
        }
        
        // Add more food to the bowl
        System.out.println("\n--- Adding more food to the bowl ---");
        bowl.addFood(30);
        
        // Feed hungry cats again
        System.out.println("\n--- Second feeding attempt ---");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eatFromBowl(bowl);
            } else {
                System.out.println(cat.getName() + " is already full.");
            }
        }
        
        // Display final satiety status
        System.out.println("\n--- Final satiety status ---");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " is full: " + cat.isFull());
        }
        
        System.out.println("\n--- Final bowl state ---");
        System.out.println(bowl);
        
        // Test edge cases
        System.out.println("\n=== TESTING EDGE CASES ===");
        
        // Test with negative food amount
        Bowl bowl2 = new Bowl(-10);
        System.out.println("Bowl with negative initial food: " + bowl2);
        
        // Test decreasing more food than available
        bowl2.addFood(5);
        bowl2.decreaseFood(10);
        
        // Test feeding with specific amounts
        System.out.println("\n--- Testing specific food amounts ---");
        Cat testCat = new Cat("TestCat");
        Bowl bowl3 = new Bowl(15);
        
        testCat.eatFromBowl(bowl3, 20); // Too much
        testCat.eatFromBowl(bowl3, 10); // Should work
        testCat.eatFromBowl(bowl3, 5);  // Already full
        
        // Update animal statistics
        System.out.println("\n--- Updated Animal Statistics ---");
        System.out.println("Total animals created: " + Animal.getAnimalCount());
        System.out.println("Total dogs created: " + Dog.getDogCount());
        System.out.println("Total cats created: " + Cat.getCatCount());
    }
}