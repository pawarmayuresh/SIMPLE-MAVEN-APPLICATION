package com.student;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testGradeA() {
        assertEquals("A", App.calculateGrade(95));
    }

    @Test
    public void testGradeB() {
        assertEquals("B", App.calculateGrade(80));
    }

    @Test
    public void testFail() {
        assertEquals("Fail", App.calculateGrade(30));
    }
}