import exceptions.MyArraySizeException;
import exceptions.MyArrayDataException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LESSON 5: EXCEPTIONS ===\n");
        
        // TEST 1: Valid array
        System.out.println("TEST 1: Valid 4x4 array");
        String[][] validArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };
        testArray(validArray);
        
        // TEST 2: Wrong size (3 rows)
        System.out.println("\nTEST 2: Wrong size - 3 rows");
        String[][] wrongRows = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"}
        };
        testArray(wrongRows);
        
        // TEST 3: Wrong size (4x3)
        System.out.println("\nTEST 3: Wrong size - 4x3");
        String[][] wrongCols = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"10", "11", "12"}
        };
        testArray(wrongCols);
        
        // TEST 4: Invalid data (text)
        System.out.println("\nTEST 4: Invalid data - text");
        String[][] invalidData = {
            {"1", "2", "3", "4"},
            {"5", "6", "seven", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };
        testArray(invalidData);
        
        // TEST 5: Null array
        System.out.println("\nTEST 5: Null array");
        testArray(null);
        
        // TEST 6: ArrayIndexOutOfBoundsException
        System.out.println("\n=== TEST 6: ArrayIndexOutOfBoundsException ===");
        demonstrateArrayIndexOutOfBounds();
    }
    
    private static void testArray(String[][] array) {
        try {
            int sum = ArrayProcessor.processArray(array);
            System.out.println("✓ SUCCESS! Sum = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("✗ SIZE ERROR: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("✗ DATA ERROR: " + e.getMessage());
            System.out.println("  Cell: [" + e.getRow() + "][" + e.getCol() + "]");
        }
    }
    
    private static void demonstrateArrayIndexOutOfBounds() {
        // Example 1: Index beyond array length
        try {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("Trying to access index 10...");
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Cannot access index beyond array bounds!");
        }
        
        // Example 2: Negative index
        try {
            int[] arr = {1, 2, 3};
            System.out.println("\nTrying to access index -1...");
            int x = arr[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Index cannot be negative!");
        }
        
        // Example 3: Loop error
        try {
            int[] arr = {10, 20, 30, 40};
            System.out.println("\nLoop with error (i <= arr.length):");
            for (int i = 0; i <= arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Loop should be i < arr.length, not i <= arr.length");
        }
        
        // Example 4: Correct way
        System.out.println("\n--- Correct way ---");
        int[] correct = {1, 2, 3, 4, 5};
        int index = 2;
        
        if (index >= 0 && index < correct.length) {
            System.out.println("correct[" + index + "] = " + correct[index]);
        } else {
            System.out.println("Index " + index + " is out of bounds!");
        }
    }
}