import student.Student;
import student.StudentManager;
import phonebook.PhoneBook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("          LESSON 6 - TASK 1            ");
        System.out.println("            STUDENT SYSTEM             ");
        System.out.println("========================================\n");
        
        task1StudentSystem();
        
        System.out.println("\n\n========================================");
        System.out.println("          LESSON 6 - TASK 2            ");
        System.out.println("           PHONE BOOK SYSTEM           ");
        System.out.println("========================================\n");
        
        task2PhoneBook();
    }
    
    // Task 1: Student System
    private static void task1StudentSystem() {
        // Create Student Manager
        StudentManager manager = new StudentManager();
        
        // Create students with different grades
        System.out.println("--- Creating Students ---");
        
        Student student1 = new Student("John Smith", "CS-101", 1);
        student1.addGrades(5, 4, 5, 4, 5); // avg = 4.6
        manager.addStudent(student1);
        
        Student student2 = new Student("Emma Watson", "CS-101", 1);
        student2.addGrades(3, 4, 3, 4, 3); // avg = 3.4
        manager.addStudent(student2);
        
        Student student3 = new Student("Michael Brown", "CS-101", 1);
        student3.addGrades(2, 3, 2, 3, 2); // avg = 2.4
        manager.addStudent(student3);
        
        Student student4 = new Student("Sarah Johnson", "MATH-201", 2);
        student4.addGrades(5, 5, 4, 5, 5); // avg = 4.8
        manager.addStudent(student4);
        
        Student student5 = new Student("David Wilson", "MATH-201", 2);
        student5.addGrades(3, 3, 2, 3, 3); // avg = 2.8
        manager.addStudent(student5);
        
        Student student6 = new Student("Lisa Anderson", "PHY-301", 3);
        student6.addGrades(4, 4, 5, 4, 4); // avg = 4.2
        manager.addStudent(student6);
        
        Student student7 = new Student("James Taylor", "PHY-301", 3);
        student7.addGrades(2, 2, 3, 2, 2); // avg = 2.2
        manager.addStudent(student7);
        
        Student student8 = new Student("Robert Martin", "CS-201", 2);
        student8.addGrades(5, 5, 5, 5, 5); // avg = 5.0
        manager.addStudent(student8);
        
        // Print all students
        System.out.println("\n--- All Students ---");
        Set<Student> allStudents = manager.getAllStudents();
        for (Student s : allStudents) {
            System.out.println("  " + s);
        }
        
        // Print statistics before operations
        manager.printStatistics();
        
        // Test printStudents method
        System.out.println("\n--- Testing printStudents method ---");
        StudentManager.printStudents(manager.getAllStudents(), 1);
        StudentManager.printStudents(manager.getAllStudents(), 2);
        StudentManager.printStudents(manager.getAllStudents(), 3);
        
        // Remove students with average grade < 3
        System.out.println("\n--- Removing poor students (avg < 3) ---");
        int removed = manager.removePoorStudents();
        System.out.println("Total removed: " + removed);
        
        // Promote students with average grade >= 3
        System.out.println("\n--- Promoting students (avg >= 3) ---");
        int promoted = manager.promoteStudents();
        System.out.println("Total promoted: " + promoted);
        
        // Print statistics after operations
        manager.printStatistics();
        
        // Test printStudents again after operations
        System.out.println("\n--- Testing printStudents after operations ---");
        StudentManager.printStudents(manager.getAllStudents(), 1);
        StudentManager.printStudents(manager.getAllStudents(), 2);
        StudentManager.printStudents(manager.getAllStudents(), 3);
        StudentManager.printStudents(manager.getAllStudents(), 4);
    }
    
    // Task 2: Phone Book System
    private static void task2PhoneBook() {
        // Create Phone Book
        PhoneBook phoneBook = new PhoneBook();
        
        // Add entries
        System.out.println("--- Adding entries to phone book ---");
        
        // Add single phone numbers
        phoneBook.add("Smith", "123-456-7890");
        phoneBook.add("Johnson", "234-567-8901");
        phoneBook.add("Williams", "345-678-9012");
        
        // Add multiple phones for the same last name
        System.out.println("\n--- Adding multiple phones for same last name ---");
        phoneBook.add("Brown", "456-789-0123");
        phoneBook.add("Brown", "567-890-1234");
        phoneBook.add("Brown", "678-901-2345");
        
        // Test homonyms (same last name)
        System.out.println("\n--- Testing homonyms (same last name) ---");
        phoneBook.add("Smith", "789-012-3456"); // Another Smith
        phoneBook.add("Smith", "890-123-4567"); // Another Smith
        
        // Add using varargs
        System.out.println("\n--- Adding multiple phones at once ---");
        phoneBook.add("Davis", "901-234-5678", "012-345-6789", "123-456-7890");
        
        // Test get method
        System.out.println("\n--- Testing get() method ---");
        
        // Get Smith's phones
        System.out.println("\nGetting phones for 'Smith':");
        List<String> smithPhones = phoneBook.get("Smith");
        for (String phone : smithPhones) {
            System.out.println("  " + phone);
        }
        
        // Get Brown's phones
        System.out.println("\nGetting phones for 'Brown':");
        List<String> brownPhones = phoneBook.get("Brown");
        for (String phone : brownPhones) {
            System.out.println("  " + phone);
        }
        
        // Test non-existent name
        System.out.println("\nGetting phones for 'Anderson' (non-existent):");
        List<String> andersonPhones = phoneBook.get("Anderson");
        if (andersonPhones.isEmpty()) {
            System.out.println("  No phones found");
        }
        
        // Display specific entries
        System.out.println("\n--- Displaying specific entries ---");
        phoneBook.displayPhones("Smith");
        phoneBook.displayPhones("Brown");
        phoneBook.displayPhones("Anderson");
        
        // Display entire phone book
        phoneBook.displayAll();
        
        // Test remove methods
        System.out.println("\n--- Testing remove() methods ---");
        
        // Remove specific phone number
        phoneBook.remove("Smith", "123-456-7890");
        
        // Remove entire entry
        phoneBook.remove("Williams");
        
        // Try to remove non-existent
        phoneBook.remove("Anderson", "000-000-0000");
        
        // Display updated phone book
        phoneBook.displayAll();
        
        // Statistics
        System.out.println("\n--- Phone Book Statistics ---");
        System.out.println("Number of entries (unique last names): " + 
                         phoneBook.getEntryCount());
        System.out.println("Total phone numbers: " + 
                         phoneBook.getTotalPhoneCount());
        
        // Test edge cases
        System.out.println("\n--- Testing edge cases ---");
        
        // Add duplicate phone number
        System.out.println("\nAdding duplicate phone number:");
        phoneBook.add("Smith", "789-012-3456");
        
        // Remove non-existent phone
        System.out.println("\nRemoving non-existent phone:");
        phoneBook.remove("Brown", "999-999-9999");
        
        // Get from empty phone book
        System.out.println("\nTesting empty phone book:");
        PhoneBook emptyBook = new PhoneBook();
        emptyBook.displayPhones("Test");
        emptyBook.displayAll();
    }
}