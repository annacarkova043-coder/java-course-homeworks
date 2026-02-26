# java-course-homeworks
Homework repository for Java course
 
## Lesson 6: Collections Framework 
Location: Lesson_6/ 
 
### Task 1: Student Management System 
- Class Student with name, group, course, grades 
- Method to remove students with average grade < 3 
- Method to promote students with average grade >= 3 
- Method printStudents(Set<Student> students, int course) 
 
### Task 2: Phone Book 
- Class PhoneBook with HashMap<String, List<String>> 
- add() method to add records 
- get() method to find phones by last name 
- Support for multiple phones under same last name 
 
### How to run Lesson 6: 
```bash 
cd Lesson_6 
javac student/*.java phonebook/*.java Main.java 
java Main 
``` 
## Lesson 7: Unit Testing with JUnit 5 and TestNG

This lesson demonstrates unit testing using two different frameworks: JUnit 5 and TestNG.

### Programs (same in both branches):
1. **FactorialCalculator** - Calculates factorial of a number
2. **TriangleAreaCalculator** - Calculates area of triangles using different formulas
3. **ArithmeticOperations** - Basic arithmetic operations (add, subtract, multiply, divide)
4. **NumberComparator** - Compares two integers with various methods

### Branches:
- **Lesson_7_junit_5**: Contains JUnit 5 unit tests
- **Lesson_7_testng**: Contains TestNG unit tests

### Structure:

### How to run:

#### With JUnit 5:
```bash
git checkout Lesson_7_junit_5
cd Lesson_7
mvn clean test

