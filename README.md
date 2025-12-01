🌊 Marine Management & Port Administration System
A Modular, Java-Based Harbor Operations Platform Demonstrating Advanced OOP and MVC Architecture

The Marine Management & Port Administration System is a comprehensive Java application engineered to demonstrate advanced Object-Oriented Programming (OOP) principles—including abstraction, inheritance, interfaces, and runtime polymorphism—within a clean and modular Model–View–Controller (MVC) architecture.

Designed as a console-based yet enterprise-style solution, the system incorporates secure user authentication, file-based data persistence, structured vehicle management, and detailed operational logging. It serves as an excellent illustration of how core software engineering principles can be combined to develop maintainable, scalable, and production-ready applications.

🚢 Core System Capabilities
🔐 Secure User Authentication

A complete registration and login framework is included.
User credentials are encrypted and stored safely in users.txt, ensuring confidentiality and preventing unauthorized access.

🚛 Comprehensive Vehicle Management

The system supports multiple marine and aerial vehicle types, each modeled through a modular class hierarchy:

RiverBarge

SeaPlane

Helicopter

Each subclass extends a central Vehicle abstract class, enabling reuse, specialization, and clean structural organization.

🌊 Runtime Polymorphism via Sailer Interface

Vehicles capable of docking implement the Sailer interface.
This design enables:

Uniform handling of docking operations

Runtime selection of appropriate dock() implementations

Clean separation of capabilities versus classification

💾 Persistent Local Storage

All critical application data—user accounts and system activity—is stored in local resource files:

users.txt (credentials)

activity.log (event audit history)

This ensures continuity across application sessions without requiring any external database.

📝 Detailed Operational Logging

Every user action—authentication attempts, vehicle operations, dock events—is timestamped and recorded in activity.log.
This provides an accurate audit trail suitable for:

Debugging

Monitoring

System auditing

🏛️ Clean MVC Architecture

The application is built around a well-structured MVC design, allowing clear separation of responsibilities:

Layer	Responsibility
Model	Core domain logic and data structures (User, Harbor, Vehicle, etc.)
View	Console-based user interface and interaction handling
Controller	Orchestrates interaction between the model and view layers

This design enables flexibility, maintainability, and scalability for future enhancements.

📁 Project Structure

The project follows the standard Maven layout for clarity and portability.

.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── harbor
│   │   │           ├── controller
│   │   │           │   ├── HarborController.java
│   │   │           │   └── UserController.java
│   │   │           ├── model
│   │   │           │   ├── Harbor.java
│   │   │           │   ├── Sailer.java        // Interface
│   │   │           │   ├── User.java
│   │   │           │   └── vehicles
│   │   │           │       ├── Helicopter.java
│   │   │           │       ├── RiverBarge.java
│   │   │           │       ├── SeaPlane.java
│   │   │           │       └── Vehicle.java   // Abstract Class
│   │   │           ├── util
│   │   │           │   └── Logger.java
│   │   │           ├── view
│   │   │           │   ├── HarborView.java
│   │   │           │   └── UserView.java
│   │   │           └── Main.java
│   │   └── resources
│   │       ├── activity.log
│   │       └── users.txt
│   └── test
└── pom.xml

Component Overview

controller – Manages system workflows and orchestrates the interaction between model and view layers

model – Domain entities and business logic

view – User-facing console interactions

util – Helper utilities

resources – Persistent storage assets

🚀 Getting Started
✔️ Prerequisites

Java Development Kit (JDK) 11+

Apache Maven

✔️ Installation
git clone https://github.com/your-username/harbor-management-system.git
cd harbor-management-system

✔️ Build the Project
mvn clean install

✔️ Run the Application
java -cp target/classes com.harbor.Main


Or run Main.java from any Java IDE.

🧱 OOP Principles Demonstrated
1️⃣ Abstraction

Vehicle (abstract class) defines shared behavior, forcing subclasses to implement specialized logic.

Sailer (interface) models capabilities, not classification.

2️⃣ Inheritance

Subclasses such as RiverBarge, Helicopter, and SeaPlane extend the Vehicle base class, inheriting attributes and methods while defining their own behavior.

3️⃣ Polymorphism

The system treats all objects implementing Sailer uniformly.
Calling dock() triggers the correct implementation based on the actual object type at runtime.

4️⃣ Encapsulation

All domain classes follow strict encapsulation:

Private fields

Public getters & setters

Controlled access to maintain data integrity

🤝 Contributing

Contributions are welcomed and appreciated.
To propose improvements:

Fork the repository

Create a feature branch

Commit your changes

Push the branch

Open a pull request

Issues and enhancement suggestions can also be submitted through GitHub.

