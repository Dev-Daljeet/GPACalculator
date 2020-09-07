package com.mycompany.gpacalculation;

import java.util.ArrayList;

public class GPACalculator {
    private static GPACalculator onlyInstance = null;
    private int totalCredit;
    private double totalGradePoint;
    private double gpa;

    private GPACalculator()
    {
        totalCredit = 0;
        totalGradePoint = 0.0;
        gpa = 0.0;
    }

    public static GPACalculator getInstance()
    {
        if (onlyInstance == null)
        {
            onlyInstance = new GPACalculator();
        }
        return onlyInstance;
    }

    public double calculateGPA(ArrayList<Course> courseList)
    {
        for(Course i: courseList) {
            if (i.getCredit() > 0) {
                totalCredit += i.getCredit();
                switch (i.getGrade()) {
                    case "A+":
                        totalGradePoint += i.getCredit() * 4.3;
                        break;
                    case "A":
                        totalGradePoint += i.getCredit() * 4;
                        break;
                    case "A-":
                        totalGradePoint += i.getCredit() * 3.7;
                        break;
                    case "B+":
                        totalGradePoint += i.getCredit() * 3.3;
                        break;
                    case "B":
                        totalGradePoint += i.getCredit() * 3;
                        break;
                    case "B-":
                        totalGradePoint += i.getCredit() * 2.7;
                        break;
                    case "C+":
                        totalGradePoint += i.getCredit() * 2.3;
                        break;
                    case "C":
                        totalGradePoint += i.getCredit() * 2;
                        break;
                    case "C-":
                        totalGradePoint += i.getCredit() * 1.7;
                        break;
                    case "D+":
                        totalGradePoint += i.getCredit() * 1.3;
                        break;
                    case "D":
                        totalGradePoint += i.getCredit() * 1;
                        break;
                    case "D-":
                        totalGradePoint += i.getCredit() * 0.7;
                        break;
                    case "F":
                        totalGradePoint += i.getCredit() * 0;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Grade");
                }
            }
            else
            {
                throw new IllegalArgumentException("Invalid Credit");
            }
        }
        gpa = totalGradePoint / totalCredit;
        return gpa;
    }
}
