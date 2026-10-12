# To-Do List Application (Spring Boot)

A simple full-stack To-Do List app built with **Spring Boot**. It exposes a REST API for managing tasks and includes a lightweight HTML/JavaScript frontend served by the same application.

Built as a learning project to practice layered architecture in Spring Boot: Controller → Service → Repository → Database.

## Features

- View all tasks
- Add a new task
- Delete a task
- REST API with JSON responses
- In-memory H2 database (no setup required)
- Simple single-page frontend using the Fetch API

## Tech Stack

| Area | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.1 |
| Web | Spring Web MVC |
| Persistence | Spring Data JPA (Hibernate) |
| Database | H2 (in-memory) |
| Build tool | Maven |
| Frontend | HTML, JavaScript (Fetch API) |

## Project Structure

```
todolist/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/example/todolist/
    │   │   ├── TodolistApplication.java   # Application entry point
    │   │   ├── model/Todo.java            # JPA entity
    │   │   ├── repository/TodoRepository.java
    │   │   ├── service/TodoService.java   # Business logic
    │   │   └── controller/TodoController.java  # REST endpoints
    │   └── resources/
    │       ├── application.properties
    │       └── static/index.html          # Frontend UI
    └── test/
        └── java/com/example/todolist/
```

## Prerequisites

- JDK 21
- Maven 3.9.x (or use the included Maven wrapper)
- Git

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
```

### 2. Run the application

Using the Maven wrapper:

```bash
# Windows
.\mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```

Or run `TodolistApplication` directly from your IDE (IntelliJ IDEA, Eclipse, VS Code).

### 3. Open the app

- UI: <http://localhost:8081/>
- API: <http://localhost:8081/api/todos>

> **Port note:** This project is configured to run on port **8081** (see `application.properties`) because port 8080 is often used by other software, such as Oracle Database XE. To use a different port, change this line:
>
> ```properties
> server.port=8081
> ```

## API Reference

Base URL: `/api/todos`

| Method | Endpoint | Description | Success response |
|---|---|---|---|
| `GET` | `/api/todos` | Get all to-dos | `200 OK` + JSON list |
| `POST` | `/api/todos` | Create a to-do | `201 Created` + created object |
| `DELETE` | `/api/todos/{id}` | Delete a to-do by ID | `204 No Content` |

### Example requests

Create a task:

```bash
curl -X POST http://localhost:8081/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Spring Boot"}'
```

Get all tasks:

```bash
curl http://localhost:8081/api/todos
```

Delete a task:

```bash
curl -X DELETE http://localhost:8081/api/todos/1
```

### Example response

```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "description": null,
    "completed": false,
    "createdAt": "2026-10-12T20:45:10.123"
  }
]
```

## Data Model

| Field | Type | Description |
|---|---|---|
| `id` | `Long` | Auto-generated primary key |
| `title` | `String` | Task title |
| `description` | `String` | Optional details |
| `completed` | `boolean` | Completion status |
| `createdAt` | `LocalDateTime` | Set automatically when the task is saved |

## H2 Console (Optional)

To inspect the in-memory database in your browser, add this to `src/main/resources/application.properties`:

```properties
spring.h2.console.enabled=true
```

Then open <http://localhost:8081/h2-console>. The JDBC URL is printed in the application startup log (look for `jdbc:h2:mem:...`).

> **Note:** H2 is in-memory, so all data is lost when the application stops.

## Running Tests

```bash
./mvnw test
```

## Building a Runnable JAR

```bash
./mvnw clean package
java -jar target/todolist-0.0.1-SNAPSHOT.jar
```


## Acknowledgements

This project is based on the tutorial [Creating a To-Do List Application with Spring Boot](https://useful.codes/creating-a-to-do-list-application-with-spring-boot/) from Useful Codes, adapted for Spring Boot 4 (Jakarta Persistence imports, getters/setters, and `createdAt` handling).


## Author

**Your Name**
GitHub: [@Rxj123](https://github.com/Rxj123)
