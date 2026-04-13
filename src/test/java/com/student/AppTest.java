package com.student;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AppTest {

    @Test
    public void testEligibleVoter() {
        Voter voter = new Voter("Priya", 25, "Indian", "IN12345", true);
        assertTrue(voter.isEligible());
        assertEquals(0, voter.getIneligibilityReasons().size());
    }

    @Test
    public void testUnderageVoter() {
        Voter voter = new Voter("Amit", 16, "Indian", "IN54321", true);
        assertFalse(voter.isEligible());
        List<String> reasons = voter.getIneligibilityReasons();
        assertEquals(1, reasons.size());
        assertEquals("Underage: must be at least 18 years old.", reasons.get(0));
    }

    @Test
    public void testNonCitizenVoter() {
        Voter voter = new Voter("John", 30, "American", "IN56789", true);
        assertFalse(voter.isEligible());
        List<String> reasons = voter.getIneligibilityReasons();
        assertEquals(1, reasons.size());
        assertEquals("Not a citizen of India.", reasons.get(0));
    }

    @Test
    public void testInvalidIdVoter() {
        Voter voter = new Voter("Sita", 28, "Indian", "IN00000", false);
        assertFalse(voter.isEligible());
        List<String> reasons = voter.getIneligibilityReasons();
        assertEquals(1, reasons.size());
        assertEquals("Invalid voter ID.", reasons.get(0));
    }

    @Test
    public void testMultipleIneligibilityReasons() {
        Voter voter = new Voter("Ravi", 15, "Pakistani", "IN00000", false);
        assertFalse(voter.isEligible());
        List<String> reasons = voter.getIneligibilityReasons();
        assertEquals(3, reasons.size());
    }

    @Test
    public void testIndianCitizenshipRecognizedForIndiaKeyword() {
        Voter voter = new Voter("Neha", 22, "India", "IN99999", true);
        assertTrue(voter.isEligible());
    }
}
