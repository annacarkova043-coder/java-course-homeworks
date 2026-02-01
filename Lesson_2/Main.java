public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        
       
        System.out.println("\n=== Task 5 ===");
        System.out.println("Sum of 5 and 7 in range 10-20: " + isSumInRange(5, 7));
        System.out.println("Sum of 10 and 5 in range 10-20: " + isSumInRange(10, 5));
        System.out.println("Sum of 5 and 20 in range 10-20: " + isSumInRange(5, 20));
        System.out.println("Sum of 11 and 12 in range 10-20: " + isSumInRange(11, 12));
        
       

        System.out.println("\n=== Task 6 ===");
        printNumberSign(10);
        printNumberSign(-5);
        printNumberSign(0);
        printNumberSign(-100);
        printNumberSign(42);
    }
    
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
    public static void checkSumSign() {
        int a = 15;
        int b = -7;
        int sum = a + b;
        
        if (sum >= 0) {
            System.out.println("Sum is positive");
        } else {
            System.out.println("Sum is negative");
        }
    }
    
    public static void printColor() {
        int value = 75;
        
        if (value <= 0) {
            System.out.println("Red");
        } else if (value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }
    
    public static void compareNumbers() {
        int a = 10;
        int b = 20;
        
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    
    
    public static void printNumberSign(int number) {
        if (number >= 0) {
            System.out.println(number + " is positive");
        } else {
            System.out.println(number + " is negative");
        }
    }
}