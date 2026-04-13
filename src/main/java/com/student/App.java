package com.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String COUNTRY = "Indian";

    public static boolean isEligibleToVote(Voter voter) {
        return voter != null && voter.isEligible();
    }

    public static Voter readVoter(Scanner scanner, int index) {
        System.out.printf("\nEnter details for voter %d:\n", index);
        System.out.print("  Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("  Age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("  Citizenship: ");
        String citizenship = scanner.nextLine().trim();

        System.out.print("  Voter ID: ");
        String voterId = scanner.nextLine().trim();

        System.out.print("  Is the Voter ID valid? (yes/no): ");
        String validInput = scanner.nextLine().trim().toLowerCase();
        boolean idValid = "yes".equals(validInput) || "true".equals(validInput) || "y".equals(validInput);

        return new Voter(name, age, citizenship, voterId, idValid);
    }

    public static void printEligibilityReport(List<Voter> voters) {
        System.out.println("\nVoting Eligibility Report");
        System.out.println("===========================");

        for (Voter voter : voters) {
            System.out.println();
            System.out.println("Voter Name : " + voter.getName());
            System.out.println("Age        : " + voter.getAge());
            System.out.println("Citizenship: " + voter.getCitizenship());
            System.out.println("Voter ID   : " + voter.getVoterId());

            if (isEligibleToVote(voter)) {
                System.out.println("Result     : Eligible to vote");
            } else {
                System.out.println("Result     : Not eligible to vote");
                System.out.println("Reasons:");
                for (String reason : voter.getIneligibilityReasons()) {
                    System.out.println("  - " + reason);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Voting Eligibility System");
            System.out.println("--------------------------");
            System.out.print("Enter number of voters: ");
            int voterCount = Integer.parseInt(scanner.nextLine().trim());

            if (voterCount <= 0) {
                throw new IllegalArgumentException("Number of voters must be at least 1.");
            }

            List<Voter> voters = new ArrayList<>();
            for (int i = 1; i <= voterCount; i++) {
                voters.add(readVoter(scanner, i));
            }

            printEligibilityReport(voters);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
