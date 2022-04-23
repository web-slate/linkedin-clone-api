
# Linkedin Clone Application
Linkedin Clone Application

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Setting Up Database in MacOS.

```
// Install Postgre SQL DB
brew install postgresql

// Start, Stop and Restart PostgreSQL Service.
brew services start postgresql
brew services stop postgresql
brew services restart postgresql

// Connect DB.
psql postgres
```

### Create New Role `guest` should return `CREATE ROLE`
```
CREATE ROLE guest WITH LOGIN PASSWORD 'demo'
```

### Add Right access to create DB should return `ALTER ROLE`.
```
ALTER ROLE guest CREATEDB;
```

### Login in to DB with below user.

```
psql postgres -U guest
```

## Install PGAdmin4
PgAdmin is software to connect DB, create table and execute SQL easier.

```
brew install --cask pgadmin4
```

## Setting up Database without modifying `application.properties`

- Create database name with `dd2jgod4ge5out` in postgres
- Create user for the created database 
```
➜  linkedin-clone-api-new git:(main) createuser --interactive --pwprompt
    Enter name of role to add: umvyqkpzkezvja
    Enter password for new role: 6fd285461e7f93c0875caa672b5a295c2e9903f026bd0616fd4ba4219102198312
    Enter it again: 6fd285461e7f93c0875caa672b5a295c2e9903f026bd0616fd4ba4219102198312
    Shall the new role be a superuser? (y/n) y
```
- Connect to the database in terminal/DBevear/any tool to import the .SQL `src/main/resources/DB/DDL` 

## Setting up Database host without modifying `application.properties`
### MacOS
- Open `/etc/hosts` in edit mode. 
- Add below lines
```
127.0.0.1 ec2-44-192-245-97.compute-1.amazonaws.com
localhost ec2-44-192-245-97.compute-1.amazonaws.com
```
- Save the file
- Run
```sudo killall -HUP mDNSResponder```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `com.linkedin.ProfessionalNetworking.LinkedInApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
# Configure Database in Local Postgres
Step 1: CreateTables scripts are available in src/main/resources/DB/DDL. Execute the Scripts in Postgres.

Step 2: Insert your own Values in the Tables T_USER and T_USER_FEED


mvn spring-boot:run

# linkedin-clone-api
Linkedin clone api in Spring Boot


Clone this project from GIT

# Execution:
Step 1: Open Terminal - mvn clean install

Step 2: Open Terminal - mvn spring-boot:run -Dspring-boot.run.profiles=local

Step 3: Accessing the application with below url. The default userid and password : admin
http://localhost:8081/api/login?userId=admin&password=admin
