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
        
        System.out.println("\n=== Task 7 ===");
        System.out.println("Number -5 is negative: " + isNegative(-5));
        System.out.println("Number 0 is negative: " + isNegative(0));
        System.out.println("Number 10 is negative: " + isNegative(10));
        
        System.out.println("\n=== Task 8 ===");
        printStringMultipleTimes("Java", 3);
        
        System.out.println("\n=== Task 9 ===");
        System.out.println("2024 is leap year: " + isLeapYear(2024));
        System.out.println("2023 is leap year: " + isLeapYear(2023));
        System.out.println("1900 is leap year: " + isLeapYear(1900));
        System.out.println("2000 is leap year: " + isLeapYear(2000));
        
        System.out.println("\n=== Task 10 ===");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Original array: ");
        printArray(array1);
        invertArray(array1);
        System.out.print("Inverted array: ");
        printArray(array1);
        
        System.out.println("\n=== Task 11 ===");
        int[] array2 = createArray1to100();
        System.out.print("Array 1..100 (first 10 elements): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("...");
        
        System.out.println("\n=== Task 12 ===");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Original array: ");
        printArray(array3);
        multiplyLessThan6(array3);
        System.out.print("After multiplication: ");
        printArray(array3);
        
        System.out.println("\n=== Task 13 ===");
        int size = 5;
        int[][] squareArray = new int[size][size];
        fillDiagonals(squareArray);
        System.out.println("Square array with diagonals:");
        print2DArray(squareArray);
        
        System.out.println("\n=== Task 14 ===");
        int[] array4 = createArrayWithValue(5, 42);
        System.out.print("Array of length 5 with value 42: ");
        printArray(array4);
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
    
    public static boolean isNegative(int number) {
        return number < 0;
    }
    
   
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
    
   
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    
  
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }
    
   
    public static int[] createArray1to100() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }
    
   
    public static void multiplyLessThan6(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }
    
    
    public static void fillDiagonals(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1; // Главная диагональ
            array[i][array.length - 1 - i] = 1; // Побочная диагональ
        }
    }
    
   
    public static int[] createArrayWithValue(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    
   
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}