
# IRCTC Booking System

This is a railway management system built using **Java**, **Spring Boot**, and **MySQL**. The system allows users to register, login, check for train availability, and book seats on trains. Admins can add new trains and update train information. The system also handles race conditions during seat bookings.

## Tech Stack

- **Java (JDK 17)**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL (Database)**
- **JWT (For token-based authentication)**
- **Maven (Build automation)**

## Prerequisites

Ensure that you have the following software installed:

- **Java Development Kit (JDK 17)**
- **MySQL Server**
- **Maven** (for building the project)
- **Postman** (or another API testing tool, optional)

## Project Setup

Follow these steps to set up and run the project:

### 1. Clone the Repository

First, clone the GitHub repository to your local machine:

bash
git clone https://github.com/Devendra-jangir/IRCTC-USING-JAVA.git


**2. Set Up MySQL Database**
Start your MySQL server and create a new database:

sql
Copy code
CREATE DATABASE irctc_db;
Configure the database connection by editing the src/main/resources/application.properties file. Replace the username and password values with your MySQL credentials:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/irctc_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialectf


**3. Build the Project**
Navigate to the project directory and run the following Maven commands to clean, compile, and install the dependencies:

bash
Copy code
mvn clean install
If you encounter any issues with dependencies, force Maven to update all dependencies:

bash
Copy code
mvn clean install -U


**4. Run the Application**
Once everything is set up, you can start the application by running the following Maven command:

bash
Copy code
mvn spring-boot:run
The server will start at http://localhost:8080.

**5. Testing the APIs**
Once the application is running, you can test the APIs using Postman or any other API client. You will need to:

Register a new user.
Login to receive a JWT token.
Use the JWT token in the Authorization header to authenticate protected endpoints.
API Endpoints
Public APIs (No Authentication Required)
Register a User

Endpoint: POST /api/users/register
Description: Registers a new user.
Request Body:
json
Copy code
{
  "username": "user1",
  "password": "password"
}
Login User

Endpoint: POST /api/users/login
Description: Logs in a user and returns a JWT token.
Request Body:
json
Copy code
{
  "username": "user1",
  "password": "password"
}
User APIs (JWT Token Required)
After logging in, use the JWT token for authentication in the Authorization header as Bearer <your_token>.

Book a Seat

Endpoint: POST /api/user/book-seat
Description: Books a seat for a specific train.
Request Body:
json
Copy code
{
  "trainId": 1
}
Check Train Availability

Endpoint: GET /api/user/get-trains?source=StationA&destination=StationB
Description: Fetches all available trains between two stations.
Admin APIs (API Key Required)
To access the Admin APIs, you need to provide an API key in the Authorization header. You can manually generate the API key and store it in the AdminSecret table in the database.

Add a Train

Endpoint: POST /api/admin/add-train
Description: Adds a new train to the system.
Request Body:
json
Copy code
{
  "source": "StationA",
  "destination": "StationB",
  "totalSeats": 100
}

**6.Add Train Schedule**

Endpoint: POST /api/admin/add-train-schedule
Description: Adds
Request Body:
json
Copy code
{
  "trainId": 1,
  "schedule": "2024-01-01 10:00:00"
}
Handling Race Conditions
The system prevents race conditions during seat booking by using row-level locking in MySQL. Only one user can book a seat at a time for the same train if multiple users try to book simultaneously.












