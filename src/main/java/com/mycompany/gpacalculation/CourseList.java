package com.mycompany.gpacalculation;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseList {
    private ArrayList<Course> courseList;

    public CourseList()
    {
        courseList = new ArrayList<>();
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<Course> addCourse(int numOfCourses)
    {
        Scanner input = new Scanner(System.in);
        for (int i=0; i<numOfCourses; i++)
        {
            System.out.println("Please enter the name of course "+(i+1));
            String courseName = input.next();
            System.out.println("Please enter the credit of course "+(i+1));
            int courseCredit = input.nextInt();
            System.out.println("Please enter the grade you achieved in course "+(i+1));
            String courseGrade = input.next();
            Course course = new Course(courseName,courseCredit,courseGrade);
            courseList.add(course);
        }
        return courseList;
    }
}
