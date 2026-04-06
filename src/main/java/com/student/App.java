package com.student;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    private static final double RATE_FIRST_100 = 1.50;
    private static final double RATE_NEXT_100 = 2.50;
    private static final double RATE_NEXT_100_AFTER_200 = 4.00;
    private static final double RATE_ABOVE_300 = 6.00;
    private static final double TAX_RATE = 0.18;
    private static final DecimalFormat FORMATTER = new DecimalFormat("0.00");

    public static double calculateBaseBill(double units) {
        if (units < 0) {
            throw new IllegalArgumentException("Units consumed cannot be negative.");
        }

        double remaining = units;
        double amount = 0.0;

        if (remaining > 300) {
            amount += (remaining - 300) * RATE_ABOVE_300;
            remaining = 300;
        }

        if (remaining > 200) {
            amount += (remaining - 200) * RATE_NEXT_100_AFTER_200;
            remaining = 200;
        }

        if (remaining > 100) {
            amount += (remaining - 100) * RATE_NEXT_100;
            remaining = 100;
        }

        if (remaining > 0) {
            amount += remaining * RATE_FIRST_100;
        }

        return amount;
    }

    public static double calculateTax(double baseBill) {
        if (baseBill < 0) {
            throw new IllegalArgumentException("Base bill cannot be negative.");
        }
        return baseBill * TAX_RATE;
    }

    public static double calculateFinalBill(double units) {
        double baseBill = calculateBaseBill(units);
        return baseBill + calculateTax(baseBill);
    }

    public static String getSlabDetails(double units) {
        if (units < 0) {
            throw new IllegalArgumentException("Units consumed cannot be negative.");
        }

        double remaining = units;
        StringBuilder details = new StringBuilder();
        details.append("Slab wise billing details:\n");

        if (remaining > 0) {
            double slab = Math.min(100, remaining);
            details.append("  0-100 units @ ").append(FORMATTER.format(RATE_FIRST_100)).append(" = ")
                    .append(FORMATTER.format(slab * RATE_FIRST_100)).append("\n");
            remaining -= slab;
        }

        if (remaining > 0) {
            double slab = Math.min(100, remaining);
            details.append("  101-200 units @ ").append(FORMATTER.format(RATE_NEXT_100)).append(" = ")
                    .append(FORMATTER.format(slab * RATE_NEXT_100)).append("\n");
            remaining -= slab;
        }

        if (remaining > 0) {
            double slab = Math.min(100, remaining);
            details.append("  201-300 units @ ").append(FORMATTER.format(RATE_NEXT_100_AFTER_200)).append(" = ")
                    .append(FORMATTER.format(slab * RATE_NEXT_100_AFTER_200)).append("\n");
            remaining -= slab;
        }

        if (remaining > 0) {
            details.append("  Above 300 units @ ").append(FORMATTER.format(RATE_ABOVE_300)).append(" = ")
                    .append(FORMATTER.format(remaining * RATE_ABOVE_300)).append("\n");
        }

        return details.toString();
    }

    public static String formatAmount(double amount) {
        return FORMATTER.format(amount);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter units consumed: ");
            double units = scanner.nextDouble();

            double baseBill = calculateBaseBill(units);
            double tax = calculateTax(baseBill);
            double finalBill = baseBill + tax;

            System.out.println();
            System.out.println("Electricity Bill Summary");
            System.out.println("-------------------------");
            System.out.println("Units consumed: " + formatAmount(units));
            System.out.print(getSlabDetails(units));
            System.out.println("Base bill: " + formatAmount(baseBill));
            System.out.println("Tax (" + (int) (TAX_RATE * 100) + "%): " + formatAmount(tax));
            System.out.println("Final bill: " + formatAmount(finalBill));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
