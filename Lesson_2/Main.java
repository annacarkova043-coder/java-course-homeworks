public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
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
}