
# Linkedin Clone Application
Linkedin Clone Application

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `com.linkedin.ProfessionalNetworking.LinkedInApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run

# linkedin-clone-api
Linkedin clone api in Spring Boot

# Configure Database in Local Postgres
Step 1: CreateTables scripts are available in src/main/resources/DB/DDL. Execute the Scripts in Postgres.

Step 2: Insert your own Values in the Tables T_USER and T_USER_FEED

Clone this project from GIT

# Execution:
Step 1: Open Terminal - mvn clean install

Step 2: Open Terminal - mvn spring-boot:run -Dspring-boot.run.profiles=local

Step 3: Accessing the application with below url. The default userid and password : admin
http://localhost:8081/api/login?userId=admin&password=admin