public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
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
}