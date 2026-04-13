package com.student;

import java.util.Objects;

public final class Course {

    private final String name;
    private final int credits;

    public Course(String name, int credits) {
        this.name = Objects.requireNonNull(name, "Course name cannot be null").trim();
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }

        if (credits < 0) {
            throw new IllegalArgumentException("Course credits cannot be negative.");
        }

        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
