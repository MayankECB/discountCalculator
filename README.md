
# The Retail Store Discounts




## Overview
This project is a Spring Boot application, designed to calculate the net payable amount for a user on a retail website. 
It considers multiple discount rules including percentage-based discounts (for employees, affiliates, or long-term customers) and a fixed discount for every $100 on the bill. 
The application uses asynchronous programming to process discount calculations in the background.

## Key Features:
#### 1. Percentage-Based Discounts:
 - Employees get a 30% discount.
 - Affiliates get a 10% discount.
 - Customers with over 2 years of loyalty get a 5% discount.
 - Only one percentage-based discount is applicable per bill, and no percentage discount applies to groceries.

#### 2. Fixed Discount:
 - A $5 discount is applied for every $100 spent.

#### 3. Asynchronous Processing:
 - Discounts are calculated asynchronously to improve performance.

#### 4. Unit Testing:
 - Comprehensive test coverage using JUnit to validate various discount scenarios.
      
## Project Structure
```md
src
├── main
│   ├── java
│   │   ├── com.example.retaildiscount
│   │   │   ├── RetailDiscountApplication.java      # Main Spring Boot Application Class
│   │   │   ├── model
│   │   │   │   ├── User.java                      # User class that stores user information
│   │   │   │   ├── Bill.java                      # Bill class that stores the bill amount and type
│   │   │   ├── service
│   │   │   │   ├── DiscountService.java           # Core service to calculate discounts asynchronously
│   │   │   ├── strategy
│   │   │   │   ├── DiscountStrategy.java          # Interface for different discount strategies
│   │   │   │   ├── PercentageDiscountStrategy.java # Implementation for percentage-based discount
│   │   │   │   ├── FixedAmountDiscountStrategy.java # Implementation for fixed discount
├── test
│   ├── java
│   │   ├── com.example.retaildiscount
│   │   │   ├── DiscountServiceTest.java           # JUnit test cases for discount calculation
```
## Prerequisites
To build and run this project, you will need:
 - Java 11 or higher
- Maven 3.6 or higher
- Spring Boot 2.7.x or higher
## Build and Run
#### Step 1: Clone the repository

 - git clone https://github.com/MayankECB/discountCalculator.git
 - cd discountCalculator

#### Step 2: Build the project using Maven
 - mvn clean install

#### Step 3: Run the Spring Boot application
 - mvn spring-boot:run
The application will start on http://localhost:8080/

#### Step 4 : Run test cases with code coverage
 - mvn test
