# SIMPLE-MAVEN-APPLICATION

This is a simple Java Maven application that evaluates voter eligibility for the Indian election system.

## Features

- Defines a `Voter` class with fields for:
  - name
  - age
  - citizenship
  - voter ID
  - ID validity status
- Reads input for one or more voters
- Validates eligibility using these rules:
  - at least 18 years old
  - Indian citizen
  - valid voter ID
- Prints an eligibility report for each voter and lists the reason(s) when ineligible

## Usage

Run the application and follow the prompts:

```bash
mvn compile exec:java -Dexec.mainClass="com.student.App"
```

Example input flow:

- Enter number of voters
- Enter name, age, citizenship, voter ID, and whether the voter ID is valid

## Build and test

```bash
mvn test
```

## Jenkins Pipeline

A `Jenkinsfile` is included for CI/CD. It performs:

- checkout from source control
- Maven build and test
- publishing JUnit test results

Use the pipeline definition from `Jenkinsfile` in your Jenkins Pipeline project.
