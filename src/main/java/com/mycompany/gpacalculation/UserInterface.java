package com.mycompany.gpacalculation;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello!\nPlease enter the number of courses for which you want to calculate GPA");
        int numOfCourses = input.nextInt();
        ArrayList<Course> courseList = new CourseList().addCourse(numOfCourses);
        GPACalculator calculator = GPACalculator.getInstance();
        System.out.printf("Your GPA is %.2f",calculator.calculateGPA(courseList));
    }
}
