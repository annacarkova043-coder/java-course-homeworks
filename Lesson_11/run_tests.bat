@echo off
echo Running MTS tests with Allure reporting...
cd C:\projects\java-course-homeworks\Lesson_11

echo Step 1: Clean and run tests
call mvn clean test

echo Step 2: Generate Allure report
call mvn allure:report

echo Step 3: Serve Allure report (will open in browser)
call mvn allure:serve

pause