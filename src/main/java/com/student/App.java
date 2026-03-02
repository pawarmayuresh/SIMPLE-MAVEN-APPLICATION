package com.student;

public class App {

    public static String calculateGrade(int marks) {

        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "Fail";
    }

    public static void main(String[] args) {
        System.out.println(calculateGrade(85));
    }
}