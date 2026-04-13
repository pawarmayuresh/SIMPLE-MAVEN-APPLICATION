package com.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static Student readStudent(Scanner scanner) {
        System.out.println("Enter student details:");
        System.out.print("  Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("  Student ID: ");
        String studentId = scanner.nextLine().trim();

        return new Student(name, studentId);
    }

    public static Course readCourse(Scanner scanner, int index) {
        System.out.printf("\nEnter details for subject %d:\n", index);
        System.out.print("  Subject name: ");
        String name = scanner.nextLine().trim();

        System.out.print("  Credit value: ");
        int credits = Integer.parseInt(scanner.nextLine().trim());

        return new Course(name, credits);
    }

    public static List<Course> readCourses(Scanner scanner, int courseCount) {
        List<Course> courses = new ArrayList<>();
        for (int i = 1; i <= courseCount; i++) {
            courses.add(readCourse(scanner, i));
        }
        return courses;
    }

    public static void printRegistrationReport(CourseRegistration registration) {
        Student student = registration.getStudent();

        System.out.println("\nCourse Registration Summary");
        System.out.println("===========================");
        System.out.println("Student name : " + student.getName());
        System.out.println("Student ID   : " + student.getStudentId());
        System.out.println("\nRegistered subjects:");

        for (Course course : registration.getCourses()) {
            System.out.printf("  - %s (%d credits)%n", course.getName(), course.getCredits());
        }

        System.out.println("\nTotal credits: " + registration.getTotalCredits());
        System.out.println("Eligibility  : " + (registration.isEligible() ? "Eligible" : "Not eligible"));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Course Registration System");
            System.out.println("---------------------------");
            System.out.print("Enter number of subjects to register: ");
            int courseCount = Integer.parseInt(scanner.nextLine().trim());

            if (courseCount <= 0) {
                throw new IllegalArgumentException("Number of subjects must be at least 1.");
            }

            Student student = readStudent(scanner);
            List<Course> courses = readCourses(scanner, courseCount);
            CourseRegistration registration = new CourseRegistration(student, courses);
            printRegistrationReport(registration);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
