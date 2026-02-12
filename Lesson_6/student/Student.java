package student;

import java.util.List;
import java.util.ArrayList;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;
    
    // Constructor
    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>();
    }
    
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public int getCourse() {
        return course;
    }
    
    public void setCourse(int course) {
        this.course = course;
    }
    
    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }
    
    public void setGrades(List<Integer> grades) {
        this.grades = new ArrayList<>(grades);
    }
    
    // Methods to work with grades
    public void addGrade(int grade) {
        if (grade >= 1 && grade <= 5) {
            grades.add(grade);
        } else {
            System.out.println("Grade must be between 1 and 5");
        }
    }
    
    public void addGrades(int... grades) {
        for (int grade : grades) {
            addGrade(grade);
        }
    }
    
    // Calculate average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    
    // Check if student can be promoted to next course
    public boolean canPromote() {
        return getAverageGrade() >= 3.0;
    }
    
    @Override
    public String toString() {
        return String.format("Student{name='%s', group='%s', course=%d, avgGrade=%.2f, grades=%s}",
                name, group, course, getAverageGrade(), grades);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return name.equals(student.name) && 
               group.equals(student.group) && 
               course == student.course;
    }
    
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + group.hashCode();
        result = 31 * result + course;
        return result;
    }
}