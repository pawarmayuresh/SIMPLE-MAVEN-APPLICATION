package com.student;

import java.util.Objects;

public final class Student {

    private final String name;
    private final String studentId;

    public Student(String name, String studentId) {
        this.name = Objects.requireNonNull(name, "Student name cannot be null").trim();
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }

        this.studentId = Objects.requireNonNull(studentId, "Student ID cannot be null").trim();
        if (this.studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}
