package com.mycompany.gpacalculation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GPACalculatorTest {

    private GPACalculator calculator = GPACalculator.getInstance();

    @Test
    public void gpaShouldBeCalculated() {
        ArrayList<Course> courseList = new ArrayList<>();
        String[] gradeArray = {"A+","D","C-"};
        for (int i=0; i<3; i++)
        {
            String name = "Course "+(i+1);
            int credit = i+2;
            String grade = gradeArray[i];
            Course course = new Course(name,credit,grade);
            courseList.add(course);
        }

        double result = calculator.calculateGPA(courseList);
        double expResult = 2.0444444444444443;

        assertEquals(expResult,result);
    }

    @Test
    public void exceptionForNumOfCoursesShouldBEThrown() {
        CourseList courseList = new CourseList();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            courseList.addCourse(-4);                // Negative or Invalid number of courses
        });

        String result = exception.getMessage();
        String expResult = "Invalid number of courses";

        assertEquals(expResult,result);
    }

    @Test
    public void exceptionForGradeShouldBEThrown() {
        ArrayList<Course> courseList = new ArrayList<>();
        String[] gradeArray = {"X","Y","Z"};       // Invalid Grade
        for (int i=0; i<3; i++)
        {
            String name = "Course "+(i+1);
            int credit = i+2;
            String grade = gradeArray[i];
            Course course = new Course(name,credit,grade);
            courseList.add(course);
        }

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           calculator.calculateGPA(courseList);
        });

        String result = exception.getMessage();
        String expResult = "Invalid Grade";

        assertEquals(expResult,result);
    }

    @Test
    public void exceptionForCreditShouldBEThrown() {
        ArrayList<Course> courseList = new ArrayList<>();
        String[] gradeArray = {"A","D","C-"};
        for (int i=0; i<3; i++)
        {
            String name = "Course "+i;
            int credit = -i;                                 // Negative or Invalid Credit
            String grade = gradeArray[i];
            Course course = new Course(name,credit,grade);
            courseList.add(course);
        }

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateGPA(courseList);
        });

        String result = exception.getMessage();
        String expResult = "Invalid Credit";

        assertEquals(expResult,result);
    }

}