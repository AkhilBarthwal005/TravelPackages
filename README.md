# Travel Package Booking System

This is a simple Java-based travel package booking system that enables users to create travel packages, add passengers, and book activities. The system supports various passenger types, including Standard, Gold, and Premium, each with its own signup strategy.

## How to Use

1. Clone the repository to your local machine:

   ```bash
   git clone <repository-url>
2. Open the project in your preferred Java development environment.

3. Run the Client class, which contains the main method, to execute the travel package booking system.

4. Follow the instructions in the console to create a travel package, add passengers, and book activities.

### Note: Running Test Cases
For running test cases, ensure you have added the external JUnit JAR to your classpath. Since this is a simple Java project and not a Spring Boot project, the JUnit library needs to be included separately for testing.

### Diagrams
You will be able to locate the highly detailed (HLD) and low-level design (LLD) diagrams for this project, which provide a comprehensive visual representation of the project's architecture and components, inside the src folder.

# Features
**Create Travel Package:** Create a travel package with a specified name, capacity, and itinerary (list of destinations with associated activities).

**Add Passengers:** Add passengers to the travel package. Passengers can be of three types: Standard, Gold, and Premium.

**Book Activities:** Book activities for passengers in the travel package. The booking process includes checking available space,  passenger balance, and applying discounts for Gold passengers.

**Print Package Details:** View the details of the created travel package, including the itinerary, available activities, and passenger list.

**Print Passenger Details:** View individual details of passengers, including their name, number, available balance, and enrolled activities.

**Print Available Activities:** See a list of activities with available spaces at each destination.

## In terms of SOLID principles:


**Single Responsibility Principle (SRP):** Each class has a single responsibility and performs a specific set of actions.

**Open/Closed Principle (OCP):** The code is open for extension (e.g., adding new passenger types) but closed for modification.

**Liskov Substitution Principle (LSP):** The subclasses (StandardPassenger, GoldPassenger, PremiumPassenger) can be used interchangeably with the base class (Passenger).

**Interface Segregation Principle (ISP):** The SignupStrategies interface defines a specific method for signing up for an activity, which is implemented by the concrete strategy classes.

**Dependency Inversion Principle (DIP):** The high-level modules (Client, TravelPackageController) depend on abstractions (interfaces) rather than concrete implementations.

# Dependencies
The project uses Java and does not have external dependencies beyond the standard Java libraries.

# Contributors
Akhil Barthwal

Feel free to contribute to this project by forking and creating a pull request.

