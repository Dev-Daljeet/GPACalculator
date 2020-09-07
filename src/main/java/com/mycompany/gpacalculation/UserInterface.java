package com.mycompany.gpacalculation;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courseList = new ArrayList<>();
        System.out.println("Hello!\nPlease enter number of courses for which you want to calculate GPA");
        int numOfCourses = input.nextInt();
        for (int i=0; i<numOfCourses; i++)
        {
            System.out.println("Please enter the name of course");
            String courseName = input.next();
            System.out.println("Please enter the value of credit");
            int courseCredit = input.nextInt();
            System.out.println("Please enter the achieved grade");
            String courseGrade = input.next();
            Course course = new Course(courseName,courseCredit,courseGrade);
            courseList.add(course);
        }
        Calculator gpaCalculator = Calculator.getInstance();
        System.out.println("Your GPA is "+gpaCalculator.calculateGPA(courseList));
    }
}
