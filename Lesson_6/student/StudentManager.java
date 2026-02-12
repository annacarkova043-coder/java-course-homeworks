package student;

import java.util.*;

public class StudentManager {
    private Set<Student> students;
    
    // Constructor
    public StudentManager() {
        this.students = new HashSet<>();
    }
    
    public StudentManager(Set<Student> students) {
        this.students = new HashSet<>(students);
    }
    
    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added: " + student.getName());
    }
    
    // Add multiple students
    public void addStudents(Student... studentArray) {
        for (Student student : studentArray) {
            addStudent(student);
        }
    }
    
    // Method 1: Remove students with average grade < 3
    public int removePoorStudents() {
        Iterator<Student> iterator = students.iterator();
        int removedCount = 0;
        
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
                removedCount++;
                System.out.println("Removed: " + student.getName() + " (avg grade: " + 
                                 String.format("%.2f", student.getAverageGrade()) + ")");
            }
        }
        
        return removedCount;
    }
    
    // Method 2: Promote students to next course if average grade >= 3
    public int promoteStudents() {
        int promotedCount = 0;
        
        for (Student student : students) {
            if (student.canPromote()) {
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
                promotedCount++;
                System.out.println("Promoted: " + student.getName() + 
                                 " from course " + oldCourse + 
                                 " to course " + student.getCourse());
            }
        }
        
        return promotedCount;
    }
    
    // Method 3: Print students by course
    public void printStudents(int course) {
        System.out.println("\n--- Students on course " + course + " ---");
        boolean found = false;
        
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  • " + student.getName() + " (Group: " + 
                                 student.getGroup() + ", Avg: " + 
                                 String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("  No students found on course " + course);
        }
    }
    
    // Overloaded method to match exactly the task: printStudents(Set<Student> students, int course)
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\n--- Students on course " + course + " ---");
        boolean found = false;
        
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  • " + student.getName());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("  No students found on course " + course);
        }
    }
    
    // Get all students
    public Set<Student> getAllStudents() {
        return new HashSet<>(students);
    }
    
    // Get students by course
    public Set<Student> getStudentsByCourse(int course) {
        Set<Student> result = new HashSet<>();
        
        for (Student student : students) {
            if (student.getCourse() == course) {
                result.add(student);
            }
        }
        
        return result;
    }
    
    // Get statistics
    public void printStatistics() {
        System.out.println("\n=== STUDENT STATISTICS ===");
        System.out.println("Total students: " + students.size());
        
        if (students.isEmpty()) {
            return;
        }
        
        // Group by course
        Map<Integer, Integer> courseCount = new HashMap<>();
        Map<Integer, Double> courseAvgGrade = new HashMap<>();
        Map<Integer, Double> courseSumGrade = new HashMap<>();
        
        for (Student student : students) {
            int course = student.getCourse();
            double avg = student.getAverageGrade();
            
            courseCount.put(course, courseCount.getOrDefault(course, 0) + 1);
            courseSumGrade.put(course, courseSumGrade.getOrDefault(course, 0.0) + avg);
        }
        
        // Calculate averages
        for (int course : courseCount.keySet()) {
            double sum = courseSumGrade.get(course);
            int count = courseCount.get(course);
            courseAvgGrade.put(course, sum / count);
        }
        
        // Print by course
        for (int course : new TreeSet<>(courseCount.keySet())) {
            System.out.println("Course " + course + ": " + 
                             courseCount.get(course) + " students, " +
                             "average grade: " + 
                             String.format("%.2f", courseAvgGrade.get(course)));
        }
    }
}