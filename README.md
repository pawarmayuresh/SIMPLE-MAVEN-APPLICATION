# SIMPLE-MAVEN-APPLICATION

This is a simple Java Maven application that calculates an electricity bill based on
units consumed, slab-wise billing, and tax.

## Features

- Calculates base electricity charges using slab rates:
  - 0-100 units @ 1.50 per unit
  - 101-200 units @ 2.50 per unit
  - 201-300 units @ 4.00 per unit
  - Above 300 units @ 6.00 per unit
- Applies a tax rate of 18% on the base bill
- Prints a detailed bill summary with slab breakdown, base amount, tax, and final amount
- Includes unit tests for billing and tax calculation logic

## Usage

Run the application and enter the number of units consumed when prompted.

```bash
mvn compile exec:java -Dexec.mainClass="com.student.App"
```
