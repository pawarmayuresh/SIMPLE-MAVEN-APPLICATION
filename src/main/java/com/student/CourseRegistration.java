package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CourseRegistration {

    public static final int MINIMUM_ELIGIBLE_CREDITS = 15;

    private final Student student;
    private final List<Course> courses;

    public CourseRegistration(Student student, List<Course> courses) {
        this.student = Objects.requireNonNull(student, "Student cannot be null");
        this.courses = new ArrayList<>(Objects.requireNonNull(courses, "Courses cannot be null"));
    }

    public Student getStudent() {
        return student;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public int getTotalCredits() {
        return courses.stream().mapToInt(Course::getCredits).sum();
    }

    public boolean isEligible() {
        return getTotalCredits() >= MINIMUM_ELIGIBLE_CREDITS;
    }
}
