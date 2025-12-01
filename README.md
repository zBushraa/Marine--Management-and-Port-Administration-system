
# ⚓ Harbor Management System

A complete Java-based Harbor Management System that demonstrates core Object-Oriented Programming (OOP) concepts including interfaces, abstract classes, inheritance, and polymorphism. The system is built with a clean MVC architecture and includes essential features like user authentication with file-based storage and comprehensive activity logging.

This project serves as an excellent example of applying fundamental software engineering principles to build a robust and maintainable console-based application.

***

## 🚢 Core Features

This system is packed with features that showcase a well-structured Java application.

-   🔐 **User Authentication**: A secure login and registration system. User credentials are encrypted and persisted in a local file (`users.txt`), ensuring data integrity and security.

-   🚛 **Vehicle Management**: Easily manage various types of vehicles within the harbor. The system supports different vehicle classes like `RiverBarge`, `SeaPlane`, and `Helicopter`, each with unique properties and behaviors.

-   🌊 **Polymorphism in Action**: Utilizes a `Sailer` interface to demonstrate polymorphism. Only vehicles that can dock (like `RiverBarge` and `SeaPlane`) implement this interface, allowing them to be treated uniformly when performing docking operations.

-   💾 **File Persistence**: All critical data, including user accounts and activity logs, is stored in local files (`users.txt`, `activity.log`). This ensures that the application state is preserved across sessions.

-   📝 **Detailed Activity Logging**: Every significant action performed by a user—from logging in to managing vehicles—is recorded in `activity.log` with a precise timestamp. This provides a clear audit trail for debugging and monitoring.

-   🏛️ **MVC Architecture**: Built on the Model-View-Controller (MVC) design pattern, the system promotes a clean separation of concerns. This makes the codebase organized, easier to understand, and highly maintainable.
    -   **Model**: Represents the data and business logic (e.g., `User`, `Vehicle`, `Harbor`).
    -   **View**: Handles the presentation layer and user interaction (console output).
    -   **Controller**: Acts as the intermediary, processing user input and updating the model and view.

***

## 📁 Project Structure

The project follows a standard Maven directory layout, ensuring clarity and build compatibility.

```
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
│   │   │           │   ├── Sailer.java         // Interface
│   │   │           │   ├── User.java
│   │   │           │   └── vehicles
│   │   │           │       ├── Helicopter.java
│   │   │           │       ├── RiverBarge.java
│   │   │           │       ├── SeaPlane.java
│   │   │           │       └── Vehicle.java        // Abstract Class
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
│       └── ...
└── pom.xml
```

### Key Components:
-   **`controller`**: Contains the logic that ties the model and view together.
-   **`model`**: Holds the core data structures, business objects, and interfaces. The `vehicles` sub-package demonstrates inheritance.
-   **`view`**: Manages all console input and output, presenting data to the user.
-   **`util`**: Includes utility classes like the `Logger`.
-   **`Main.java`**: The entry point of the application.
-   **`resources`**: Stores data files used for persistence.

***

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

-   Java Development Kit (JDK) 11 or higher
-   Apache Maven (for dependency management and building)

### Installation & Execution

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/harbor-management-system.git
    cd harbor-management-system
    ```

2.  **Compile the project using Maven:**
    ```sh
    mvn clean install
    ```

3.  **Run the application:**
    ```sh
    java -cp target/classes com.harbor.Main
    ```
    Alternatively, you can run the `Main.java` file directly from your favorite IDE.

***

## 🧱 Core OOP Concepts Demonstrated

This project is a practical showcase of fundamental Object-Oriented Programming principles.

### 1. Abstraction
-   **Abstract Class (`Vehicle`)**: The `Vehicle` class is declared as `abstract`. It defines common attributes and methods (e.g., `id`, `name`) that all vehicles share, but it cannot be instantiated on its own. It forces subclasses to implement specific behaviors.
-   **Interface (`Sailer`)**: The `Sailer` interface defines a contract with a single method, `dock()`. Any vehicle that can perform this action (like `SeaPlane` and `RiverBarge`) must implement this interface, providing a clear separation of capabilities.

### 2. Inheritance
-   The specific vehicle classes (`Helicopter`, `RiverBarge`, `SeaPlane`) **extend** the abstract `Vehicle` class. They inherit its common properties and methods while also adding their own unique attributes and behaviors. This promotes code reuse and establishes a clear hierarchical relationship.

### 3. Polymorphism
-   The `Sailer` interface allows the system to treat different types of vehicles in a uniform way. A collection of `Sailer` objects can be created, and the `dock()` method can be called on each one, regardless of whether it's a `RiverBarge` or a `SeaPlane`. The correct `dock()` implementation is invoked at runtime based on the object's actual type.

### 4. Encapsulation
-   All classes in the model package encapsulate their data by declaring fields as `private`. Access and modification are controlled through `public` getters and setters, protecting the internal state of the objects and ensuring data integrity.

***

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

***

## 📄 License

Distributed under the MIT License. See `LICENSE.txt` for more information.
