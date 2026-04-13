# SIMPLE-MAVEN-APPLICATION

This Maven project implements a Course Registration System.

## Features

- Stores student details: name and student ID
- Stores selected subjects with credit values
- Calculates total registered credits
- Determines eligibility if total credits are 15 or more
- Displays student details, registered subjects, total credits, and eligibility status

## Run the application

```bash
mvn compile exec:java -Dexec.mainClass="com.student.App"
```

Example input flow:

1. Enter number of subjects to register
2. Enter student name and student ID
3. Enter each subject name and credit value

## Build and test

```bash
mvn test
```

## Jenkins integration

Use the provided `Jenkinsfile` in a Jenkins Pipeline job. It:

- checks out the repository
- runs Maven build and tests
- publishes JUnit test results
