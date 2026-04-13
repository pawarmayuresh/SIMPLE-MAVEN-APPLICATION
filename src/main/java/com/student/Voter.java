package com.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Voter {

    private final String name;
    private final int age;
    private final String citizenship;
    private final String voterId;
    private final boolean idValid;

    public Voter(String name, int age, String citizenship, String voterId, boolean idValid) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.age = age;
        this.citizenship = Objects.requireNonNull(citizenship, "Citizenship cannot be null");
        this.voterId = Objects.requireNonNull(voterId, "Voter ID cannot be null");
        this.idValid = idValid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean isIdValid() {
        return idValid;
    }

    public boolean isCitizen() {
        return "Indian".equalsIgnoreCase(citizenship.trim()) || "India".equalsIgnoreCase(citizenship.trim());
    }

    public boolean isEligible() {
        return age >= 18 && isCitizen() && idValid;
    }

    public List<String> getIneligibilityReasons() {
        List<String> reasons = new ArrayList<>();

        if (age < 18) {
            reasons.add("Underage: must be at least 18 years old.");
        }

        if (!isCitizen()) {
            reasons.add("Not a citizen of India.");
        }

        if (!idValid) {
            reasons.add("Invalid voter ID.");
        }

        return Collections.unmodifiableList(reasons);
    }

    public String getEligibilitySummary() {
        if (isEligible()) {
            return String.format("%s is eligible to vote.", name);
        }

        StringBuilder summary = new StringBuilder();
        summary.append(String.format("%s is not eligible to vote. Reasons:\n", name));
        for (String reason : getIneligibilityReasons()) {
            summary.append("  - ").append(reason).append("\n");
        }
        return summary.toString().trim();
    }
}
