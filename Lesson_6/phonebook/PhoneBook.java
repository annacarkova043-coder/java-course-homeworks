package phonebook;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;
    
    // Constructor
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }
    
    // Method add() - adds a record to the phone book
    public void add(String lastName, String phoneNumber) {
        // Check if last name already exists
        if (phoneBook.containsKey(lastName)) {
            // Add phone number to existing list
            List<String> phones = phoneBook.get(lastName);
            if (!phones.contains(phoneNumber)) {
                phones.add(phoneNumber);
                System.out.println("Added phone number " + phoneNumber + 
                                 " for " + lastName);
            } else {
                System.out.println("Phone number " + phoneNumber + 
                                 " already exists for " + lastName);
            }
        } else {
            // Create new list and add phone number
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            phoneBook.put(lastName, phones);
            System.out.println("Added new entry: " + lastName + 
                             " - " + phoneNumber);
        }
    }
    
    // Overloaded add method for adding multiple phones at once
    public void add(String lastName, String... phoneNumbers) {
        for (String phone : phoneNumbers) {
            add(lastName, phone);
        }
    }
    
    // Method get() - finds phone numbers by last name
    public List<String> get(String lastName) {
        if (phoneBook.containsKey(lastName)) {
            return new ArrayList<>(phoneBook.get(lastName));
        } else {
            return new ArrayList<>(); // Return empty list if not found
        }
    }
    
    // Method to display all phone numbers for a last name
    public void displayPhones(String lastName) {
        List<String> phones = get(lastName);
        
        if (phones.isEmpty()) {
            System.out.println("No phone numbers found for " + lastName);
        } else {
            System.out.println("\n--- Phone numbers for " + lastName + " ---");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + phones.get(i));
            }
        }
    }
    
    // Method to remove a phone number
    public boolean remove(String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            List<String> phones = phoneBook.get(lastName);
            boolean removed = phones.remove(phoneNumber);
            
            if (removed) {
                System.out.println("Removed phone " + phoneNumber + 
                                 " for " + lastName);
                
                // If no phones left, remove the entry
                if (phones.isEmpty()) {
                    phoneBook.remove(lastName);
                    System.out.println("Removed entry for " + lastName + 
                                     " (no phones left)");
                }
                return true;
            }
        }
        
        System.out.println("Phone number " + phoneNumber + 
                         " not found for " + lastName);
        return false;
    }
    
    // Method to remove entire entry by last name
    public boolean remove(String lastName) {
        if (phoneBook.containsKey(lastName)) {
            phoneBook.remove(lastName);
            System.out.println("Removed all entries for " + lastName);
            return true;
        }
        
        System.out.println("No entry found for " + lastName);
        return false;
    }
    
    // Method to get all entries
    public Map<String, List<String>> getAllEntries() {
        Map<String, List<String>> copy = new HashMap<>();
        
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        
        return copy;
    }
    
    // Method to display entire phone book
    public void displayAll() {
        System.out.println("\n=== PHONE BOOK DIRECTORY ===");
        
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty");
            return;
        }
        
        // Sort by last name
        TreeMap<String, List<String>> sorted = new TreeMap<>(phoneBook);
        
        for (Map.Entry<String, List<String>> entry : sorted.entrySet()) {
            System.out.println("\n" + entry.getKey() + ":");
            List<String> phones = entry.getValue();
            for (int i = 0; i < phones.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + phones.get(i));
            }
        }
    }
    
    // Get total number of entries (unique last names)
    public int getEntryCount() {
        return phoneBook.size();
    }
    
    // Get total number of phone numbers
    public int getTotalPhoneCount() {
        int count = 0;
        for (List<String> phones : phoneBook.values()) {
            count += phones.size();
        }
        return count;
    }
}