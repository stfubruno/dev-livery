# Dev-livery API

A high-performance backend for a modern food delivery platform, built with a microservices architecture. This project serves as a portfolio piece to demonstrate skills in building scalable, efficient, and well-documented backend systems using Kotlin, Spring Boot, and NoSQL databases.

## Core Technologies

This project leverages a modern technology stack designed for performance and scalability:

- **Language:** Kotlin
- **Framework:** Spring Boot
- **Databases:**
   - **MongoDB:** Used for persistent storage of core data like restaurant details, menus, and finalized orders.
   - **Redis:** Used for high-speed, temporary data storage, such as user shopping carts and caching.
- **Containerization:** Docker & Docker Compose create a consistent and isolated development environment for our databases.
- **Build Tool:** Gradle

---

## Project Architecture

The system is designed as a set of communicating microservices. Each service is a standalone Spring Boot application located in its own directory.

-   **`restaurant-service`**: Manages all data related to restaurants, including their menus, locations, operating hours, and cuisine types.
-   **`order-service`**: Handles the lifecycle of an order, from managing the user's shopping cart in Redis to finalizing the order in MongoDB.

---

## Getting Started

To run this project, you will need to have [Docker](https://www.docker.com/get-started) and a JDK (Java Development Kit) version 17 or later installed.

### 1. Launch Dependencies

The project requires MongoDB and Redis instances. You can launch both using the provided Docker Compose file. From the root `dev-livery` directory, run the following command in your terminal:

```bash
docker compose up -d
```
This will start the required databases in the background.

### 2. Run the Microservices

Each microservice must be run as a separate application.

#### To run the Restaurant Service:
Open a **new terminal window**, navigate into the `restaurant-service` directory, and run the application using the Gradle wrapper.
```bash
cd restaurant-service
./gradlew bootRun
```

#### To run the Order Service:
Open **another new terminal window**, navigate into the `order-service` directory, and run the application.
```bash
cd order-service
    
```

You will now have both microservices and their databases running simultaneously.

---

## API Documentation

Each microservice will include its own API documentation (e.g., using Swagger/OpenAPI) to provide a clear and interactive way to explore its endpoints.
