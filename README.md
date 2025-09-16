# Getting Started
This is a Thymeleaf/Java Spring Boot application and uses a in-memory database.
Ensure that you have java 21 installed and configured on your machine.

Note that this project is intended to showcase the importance of clean code practices and may not include comprehensive error handling or security features.

### Features for the purpose of showcasing clean code practices:
- very dirty code, no naming conventions, limited structuring
- a security vulnerability (SQL Injection) on the login page
- a bug which prevents the user from adding food, drinks or bonfire to camp booking
  - this is deliberately hard to find and fix before the code is cleaned up

### Running the Application

Run the following command to build and run the application:

```
mvn clean install
```
Run the project either using your IDE or by executing the following command:

```
mvn spring-boot:run
```

Log in with the user Bob (password: cancelled). Feel free to change this in the `V1__Create_login_table.sql` file.


