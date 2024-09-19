
# The Retail Store Discounts

## Overview
This project is a Spring Boot application, designed to calculate the net payable amount for a user on a retail website. 
It considers multiple discount rules including percentage-based discounts (for employees, affiliates, or long-term customers) and a fixed discount for every $100 on the bill. 
The application uses asynchronous programming to process discount calculations in the background.

## Technologies Used
 - **Java** 11 or later
- **Maven** for dependency management and project build
- **Spring Boot** for the application framework
- **JUnit5** for unit testing

## Installation & Setup
#### Prerequisites
Ensure you have the following installed:
 - Java 11 or later
 - Maven
 - An IDE such as IntelliJ IDEA or Eclipse (optional, but recommended)

## Steps to Set Up:
#### Step 1: Clone the repository

 - git clone https://github.com/MayankECB/discountCalculator.git
 - cd discountCalculator

#### Step 2: Build the project using Maven
 - mvn clean install

#### Step 3: Run the Application: You can run the Spring Boot application using the following command:
 - mvn spring-boot:run
 - The application will start on http://localhost:8080/

#### Step 4 : Run test cases with code coverage
 - mvn test

## Key Features:
#### Percentage-Based Discounts:
 - 30% discount for employees of the store.
 - 10% discount for affiliates of the store.
 - 5% discount for customers who have been with the store for more than 2 years.
 - Note: Only one percentage-based discount can be applied per bill, and percentage discounts are not applicable to groceries.

#### Fixed Discount:
 - A $5 discount is applied for every $100 spent.

#### Object-Oriented Design:
 - The project uses an object-oriented approach to separate the user, invoice, and discount strategies for better maintainability and scalability.

#### Design Pattern:
 - Strategy design pattern to choose either Pecentage Based or Fixed discount during run time.

#### Asynchronous Processing:
 - Discounts are calculated asynchronously to improve performance.

#### Unit Testing:
 - Comprehensive test coverage using JUnit to validate various discount scenarios.
      
## Project Structure
 - **User Class:** Stores user information like employment status, affiliation, and customer tenure.
 - **Invoice Class:** Stores invoice details such as total amount and whether the bill includes groceries.
 - **CalculateDiscountStrategy Interface:** Interface for implementing different discount strategies.
 - **PercentageDiscountStrategyImplementation:** Applies percentage-based discounts based on the user type.
 - **FixedAmountDiscountStrategyImplementation:** Applies fixed-amount discounts based on the total bill amount.
 - **CalculateDiscountService:** Performs the asynchronous calculation of the net payable amount by applying the appropriate discounts.
 - **JUnit Tests:** Comprehensive unit tests for all discount scenarios.

```md
src
├── main
│   ├── java
│   │   ├── com.calculate.discount
│   │   │   ├── DiscountCalculatorApplication.java      # Main Spring Boot Application Class
│   │   │   ├── model
│   │   │   │   ├── User.java                      # User class that stores user information
│   │   │   │   ├── Product.java                      # Product class that stores product information present in invoice
│   │   │   │   ├── Invoice.java                      # Invoice class that stores the bill amount and type
│   │   │   ├── service
│   │   │   │   ├── CalculateDiscountService.java           # Core service to calculate discounts asynchronously
│   │   │   ├── strategy
│   │   │   │   ├── CalculateDiscountStrategy.java          # Interface for different discount strategies
│   │   │   │   ├── PercentageDiscountStrategyImplementation.java # Implementation for percentage-based discount
│   │   │   │   ├── FixedAmountDiscountStrategyImplementation.java # Implementation for fixed discount
│   │   │   ├── Utility
│   │   │   │   ├── Utility.java           # Class contains utility methods 
├── test
│   ├── java
│   │   ├── com.calculte.discount
│   │   │   ├── DiscountCalculatorApplicationTests.java           # JUnit test cases for discount calculation
```

#### UML 
![alt text](https://github.com/MayankECB/discountCalculator/blob/master/src/main/resources/UML%20diagram.jpg?raw=true)


## Usage
This application calculates the net payable amount based on the following rules:
<ol>
<li>A percentage-based discount applies depending on the user’s relationship with the store.</li>
<li>If the bill contains groceries, percentage discounts are not applied.</li>
<li>A fixed discount of $5 is applied for every $100 on the bill.</li>
</ol>
The application accepts two inputs:

 - **User**: Whether the user is an employee, affiliate, or a long-term customer (over 2 years).
 - **Invoice**: The total amount of the invoice and whether groceries are included.

## Example Scenario:
For a user who is an employee and has a bill of $990 (non-grocery):
 - A 30% discount is applied to the bill, bringing it down to $693.
 - A fixed discount of $45 (for every $100) is applied, resulting in a final bill of $648.

## Asynchronous Processing
The discount calculation is handled asynchronously using Spring's @Async annotation, which improves performance in scenarios with large calculations or when processing multiple discount requests concurrently.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing
If you'd like to contribute to this project:
<ol>
 <li>Fork the repository.</li>
 <li>Create a new branch (git checkout -b feature/your-feature).</li>
 <li>Commit your changes (git commit -am 'Add some feature').</li>
 <li>Push to the branch (git push origin feature/your-feature).</li>
 <li>Create a new Pull Request.</li>
</ol>

## Contact
For any issues or suggestions, please feel free to contact:
<br>Email: mayankgupta.ecb@gmail.com</br>

