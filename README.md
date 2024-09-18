Discount Calculator - README
Overview
This project is a Spring Boot-based application that calculates the net payable amount for a user based on several discount rules for a retail store. The application follows an object-oriented design and utilizes asynchronous programming for discount calculation.

Key Features
1. Percentage-based Discounts:
	a. 30% discount for store employees.
	b. 10% discount for store affiliates.
	c. 5% discount for customers who have been shopping for over 2 years.

2. Fixed Discounts:
	a. $5 discount for every $100 spent (e.g., for $990, you get $45 as a discount).

3. Groceries Exclusion:
	a. Percentage-based discounts do not apply to groceries.

4. Single Percentage Discount Policy:
	a. A user can only receive one of the available percentage-based discounts on a bill.

The application ensures that the correct discount is applied in an optimized and asynchronous manner using Spring Boot.

Technologies Used
	1. Java 17
	2. Spring Boot 3.x
	3. JUnit 5 for testing
	4. Maven for build and dependency management
	
How to Run the Application
1. Clone the Repository: git clone https://github.com/MayankECB/discountCalculator.git
2. Navigate to the Project Directory: cd discountCalculator
3. Build the Application: Make sure Maven is installed on your system : mvn clean install
4. Run the Application: mvn spring-boot:run
   
The application will start on http://localhost:8080/.
