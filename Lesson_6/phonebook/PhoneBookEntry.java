package phonebook;

public class PhoneBookEntry {
    private String lastName;
    private String phoneNumber;
    
    public PhoneBookEntry(String lastName, String phoneNumber) {
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return lastName + ": " + phoneNumber;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        PhoneBookEntry entry = (PhoneBookEntry) obj;
        return lastName.equals(entry.lastName) && 
               phoneNumber.equals(entry.phoneNumber);
    }
    
    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}