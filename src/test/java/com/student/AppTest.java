package com.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class AppTest {

    @Test
    public void testTotalCreditsCalculation() {
        Student student = new Student("Maya", "S102");
        Course course1 = new Course("Mathematics", 4);
        Course course2 = new Course("Physics", 5);
        Course course3 = new Course("Chemistry", 6);
        CourseRegistration registration = new CourseRegistration(student, List.of(course1, course2, course3));

        assertEquals(15, registration.getTotalCredits());
    }

    @Test
    public void testEligibilityWhenCreditsAreAtLeastMinimum() {
        Student student = new Student("Neeraj", "S103");
        CourseRegistration registration = new CourseRegistration(student, List.of(new Course("Biology", 7), new Course("English", 8)));

        assertTrue(registration.isEligible());
    }

    @Test
    public void testIneligibilityWhenCreditsAreBelowMinimum() {
        Student student = new Student("Rina", "S104");
        CourseRegistration registration = new CourseRegistration(student, List.of(new Course("History", 5), new Course("Geography", 4)));

        assertFalse(registration.isEligible());
    }

    @Test
    public void testStudentAndCourseDetailsAreStoredCorrectly() {
        Student student = new Student("Asha", "S105");
        Course course = new Course("Computer Science", 5);
        CourseRegistration registration = new CourseRegistration(student, List.of(course));

        assertEquals("Asha", registration.getStudent().getName());
        assertEquals("S105", registration.getStudent().getStudentId());
        assertEquals(1, registration.getCourses().size());
        assertEquals("Computer Science", registration.getCourses().get(0).getName());
        assertEquals(5, registration.getCourses().get(0).getCredits());
    }
}
