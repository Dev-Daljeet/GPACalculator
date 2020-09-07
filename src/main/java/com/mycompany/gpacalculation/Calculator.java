package com.mycompany.gpacalculation;

import java.util.ArrayList;

public class Calculator {
    private static Calculator onlyInstance = null;
    private int totalCredit;
    private double totalGradePoint;
    private double gpa;

    private Calculator()
    {
        totalCredit = 0;
        totalGradePoint = 0.0;
        gpa = 0.0;
    }

    public static Calculator getInstance()
    {
        if (onlyInstance == null)
        {
            onlyInstance = new Calculator();
        }
        return onlyInstance;
    }

    public double calculateGPA(ArrayList<Course> courseList)
    {

        for(Course i: courseList)
        {
            totalCredit += i.getCredit();
            switch(i.getGrade())
            {
                case "A+":
                    totalGradePoint += i.getCredit()*4.3;
                    break;
                case "A":
                    totalGradePoint += i.getCredit()*4;
                    break;
                case "A-":
                    totalGradePoint += i.getCredit()*3.7;
                    break;
                case "B+":
                    totalGradePoint += i.getCredit()*3.3;
                    break;
                case "B":
                    totalGradePoint += i.getCredit()*3;
                    break;
                case "B-":
                    totalGradePoint += i.getCredit()*2.7;
                    break;
                case "C+":
                    totalGradePoint += i.getCredit()*2.3;
                    break;
                case "C":
                    totalGradePoint += i.getCredit()*2;
                    break;
                case "C-":
                    totalGradePoint += i.getCredit()*1.7;
                    break;
                case "D+":
                    totalGradePoint += i.getCredit()*1.3;
                    break;
                case "D":
                    totalGradePoint += i.getCredit()*1;
                    break;
                case "D-":
                    totalGradePoint += i.getCredit()*0.7;
                    break;
                case "F":
                    totalGradePoint += i.getCredit()*0;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Grade");
            }
        }
        gpa = totalGradePoint / totalCredit;
        return gpa;
    }
}
