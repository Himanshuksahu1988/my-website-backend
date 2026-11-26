# SPRING BOOT BACKEND — PROJECT PROGRESS

**Project:** My Website  
**Last Updated:** 31 October 2026  
**Status:** In Progress

---

# 1. PROJECT OVERVIEW

The objective is to build a full-stack web application using:

- React — Frontend
- Spring Boot — Backend
- MySQL — Database
- Docker — Containerization
- AWS — Cloud deployment

The development approach is to complete one small step at a time, understand the concepts, implement them, and verify the results.

# 2. PROJECT DETAILS

- Project name: `my-website-backend`
- Backend folder: `C:\Users\Himanshu\eclipse-workspace\my-website-backend`
- Backend GitHub: https://github.com/Himanshuksahu1988/my-website-backend
- Frontend folder: `C:\my-website`
- Frontend GitHub: https://github.com/Himanshuksahu1988/my-website
- IDE: Eclipse with Spring Tools
- Java: 17
- Spring Boot: 4.1.1
- Build tool: Maven
- Backend port: `8081`
- Frontend port: `5173`
- Database: MySQL
- API documentation: Swagger / OpenAPI

# 3. HOW TO START THE FULL-STACK APPLICATION

Whenever we want to work on the project, start the three components in the following order.

## 3.1 Start MySQL Database (Docker)

**Steps:**

1. Open Docker Desktop.
2. Go to Containers.
3. Find the container named `mycompany-db`.
4. Check whether its status is Running.

Alternatively, use Command Prompt or PowerShell:

Start the container:

```bash
docker start mycompany-db
```

Verify the container:

```bash
docker ps
```

Docker configuration:

- Container name: `mycompany-db`
- Image: `mysql:latest`
- Host port: `3307`
- Container port: `3306`

If the container is already running, there is no need to start it again.

## 3.2 Start Spring Boot Backend (Eclipse)

Project location:

```text
C:\Users\Himanshu\eclipse-workspace\my-website-backend
```

Steps:

1. Open Eclipse.
2. Open the `my-website-backend` project.
3. Find `MyWebsiteBackendApplication.java`.
4. Right-click the file.
5. Select Run As → Spring Boot App.
6. Wait until the Console confirms successful startup.

Backend URL:

```text
http://localhost:8081
```

Swagger UI:

```text
http://localhost:8081/swagger-ui.html
```

## 3.3 Start React Frontend (VS Code)

Project location:

```text
C:\my-website
```

Steps:

1. Open VS Code.
2. Open the `my-website` folder.
3. Open the integrated terminal.
4. Execute:

```bash
npm run dev
```

5. Wait until Vite displays the local development URL.

Frontend URL:

```text
http://localhost:5173
```

If dependencies have not been installed, execute this once:

```bash
npm install
```

## 3.4 Startup Order

```text
1. MySQL (Docker)
        |
        v
2. Spring Boot (Eclipse)
        |
        v
3. React (VS Code)
```

**Why this order?**

- MySQL should be available before Spring Boot connects to it.
- Spring Boot should be running before React requests backend data.
- React can then display data received from Spring Boot.

## 3.5 How to Stop the Application

1. Stop React using `Ctrl + C` in the VS Code terminal.
2. Stop Spring Boot using the red Terminate button in Eclipse Console.
3. Stop MySQL only when needed:

```bash
docker stop mycompany-db
```

You can leave MySQL running between development sessions.

# 4. SPRING BOOT PROJECT SETUP

Completed:

- Installed Spring Tools in Eclipse.
- Created Spring Boot Maven project.
- Configured Java 17.
- Added Spring Web dependency.
- Configured application port to `8081` because port 8080 was already in use.
- Successfully started the Spring Boot application.

Important files:

- `pom.xml` — Maven configuration and dependencies.
- `MyWebsiteBackendApplication.java` — Application entry point.
- `HelloController.java` — REST API controller.
- `DatabaseController.java` — Database connection verification controller.
- `application.properties` — Application configuration.
- `MyWebsiteBackendApplicationTests.java` — Test class.

# 5. REST API DEVELOPMENT

## 5.1 First REST API

Created `HelloController.java`.

Learned:

- `@RestController`
- `@GetMapping("/")`
- Basic REST API implementation.

Endpoint:

```text
GET http://localhost:8081/
```

Response:

```text
Hello from spring boot
```

Verified `200 OK` in Postman.

## 5.2 Additional REST APIs

Created and tested the following endpoints:

### GET /api/message

Returns backend message and project information.

Example response:

```json
{
  "message": "Hello from my website api",
  "project": "My Website",
  "status": "Success"
}
```

### GET /api/project

Example response:

```json
{
  "message": "My Website",
  "project": "React + Spring Boot",
  "status": "In Progress"
}
```

### GET /api/skills

Returns configured skill information:

```text
Java,Selenium,Spring Boot
```

Concepts learned:

- `@RestController`
- `@GetMapping`
- `@CrossOrigin`
- Java records
- Constructor-based dependency injection
- JSON responses

# 6. REACT AND SPRING BOOT INTEGRATION

Completed:

- Configured CORS in Spring Boot.
- Allowed React frontend origin:

```text
http://localhost:5173
```

- Connected React with Spring Boot using `fetch()`.
- Successfully displayed a message received from the backend API.

This confirms that the frontend and backend can communicate.

# 7. MYSQL DATABASE SETUP

## 7.1 Docker MySQL Container

Created and started the MySQL Docker container.

Configuration:

- Container: `mycompany-db`
- Image: `mysql:latest`
- Host port: `3307`
- Container port: `3306`

## 7.2 Database Creation

Created the database:

```sql
CREATE DATABASE my_website_db;
```

Database name:

```text
my_website_db
```

Successfully accessed the database using MySQL Workbench.

## 7.3 Spring Boot Database Configuration

Added required dependencies:

- MySQL Connector/J
- Spring Data JPA
- Spring JDBC

Configured database connection in `application.properties`.

Database URL:

```text
jdbc:mysql://localhost:3307/my_website_db
```

Example configuration:

```properties
spring.application.name=my-website-backend
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3307/my_website_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

**Security:** Supply the database password through an environment variable. Never commit actual database credentials to GitHub.

## 7.4 Database Connection Verification

Created `DatabaseController.java`.

Used `JdbcTemplate` to execute:

```sql
SELECT DATABASE();
```

Created endpoint:

```text
GET http://localhost:8081/api/database
```

Successfully received:

```json
{
  "database": "my_website_db"
}
```

This confirms Spring Boot can connect to MySQL and execute SQL queries.

**Important distinction:**

Database connectivity is completed.

However, actual database CRUD operations are still pending.

We have not yet implemented saving, retrieving, updating, or deleting actual records through Spring Boot APIs.

# 8. SWAGGER / OPENAPI INTEGRATION

Added Springdoc OpenAPI Web MVC UI dependency.

Successfully accessed Swagger UI.

Swagger URL:

```text
http://localhost:8081/swagger-ui.html
```

OpenAPI JSON:

```text
http://localhost:8081/v3/api-docs
```

Completed:

- Opened Swagger UI.
- Viewed available REST API endpoints.
- Used Try it out.
- Executed `GET /api/database` directly through Swagger.
- Received the expected database response.

Swagger helps us explore and test REST APIs directly through a browser.

# 9. CURRENT API LIST

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/` | Basic welcome response |
| GET | `/api/message` | Returns backend message |
| GET | `/api/project` | Returns project information |
| GET | `/api/skills` | Returns skill information |
| GET | `/api/database` | Verifies MySQL connection |

# 10. CURRENT VERIFICATION STATUS

| Component | Status |
|---|---|
| Docker MySQL container | Previously configured; currently running during this session |
| MySQL database connection | Verified |
| Spring Boot startup | Verified |
| `/api/database` | Verified successfully |
| Swagger UI | Accessible |
| Swagger database API execution | Verified successfully |
| `/api/message` | Implemented; current verification in progress |
| `/api/project` | Implemented; re-verification pending |
| `/api/skills` | Implemented; re-verification pending |
| React integration | Previously verified |
| Latest GitHub changes | Push status needs verification |

# 11. GIT AND GITHUB

Backend repository:

https://github.com/Himanshuksahu1988/my-website-backend

Initial commit:

- Commit: `a9c1118`
- Message: `Initial Spring Boot backend project`

Completed:

- Initialized Git.
- Created initial commit.
- Added remote `origin`.
- Renamed branch to `main`.
- Initially pushed the project to GitHub.

**Pending:** Verify that the latest code changes are committed and pushed.

Before pushing:

1. Run `git status`.
2. Review changed files.
3. Check that sensitive credentials are excluded.
4. Commit changes.
5. Push to GitHub.

# 12. NEXT STEPS

Complete one step at a time. Verify each task before moving forward.

## Phase 1 — Complete API Verification

1. Verify `GET /api/message`.
2. Verify `GET /api/project`.
3. Verify `GET /api/skills`.
4. Verify Swagger documentation.
5. Verify React-to-Spring Boot integration again.

## Phase 2 — Actual MySQL CRUD Operations

1. Create a `Skill` entity.
2. Understand `@Entity`, `@Id`, and `@GeneratedValue`.
3. Create `SkillRepository`.
4. Understand Spring Data JPA.
5. Create a service layer.
6. Create POST API to save a skill.
7. Create GET API to retrieve all skills.
8. Verify saved records in MySQL Workbench.
9. Implement PUT API to update a skill.
10. Implement DELETE API to delete a skill.

## Phase 3 — Backend Improvements

1. Exception handling.
2. Request validation.
3. DTOs and entity mapping.
4. HTTP status codes.
5. Logging.
6. Unit and integration testing.

## Phase 4 — Advanced Backend Development

1. Spring Security.
2. Authentication and authorization.
3. JWT.
4. Database relationships.
5. Pagination and sorting.

## Phase 5 — Deployment

1. Dockerize Spring Boot.
2. Connect React, Spring Boot, and MySQL through Docker.
3. Learn AWS deployment.
4. Deploy the full-stack application.

# 13. SESSION LOG

## 14 October 2026 — Spring Boot API

- Started Spring Boot application on port 8081.
- Created and tested the first GET endpoint at `/`.
- Verified `200 OK` in Postman.

## 15 October 2026 — GitHub

- Created backend GitHub repository.
- Initialized Git.
- Created initial commit.
- Connected remote and pushed code to `main`.

## Subsequent Sessions — API and Integration

- Created additional REST APIs.
- Configured CORS.
- Connected React with Spring Boot.
- Added MySQL dependencies.
- Created and started MySQL Docker container.
- Connected Spring Boot to MySQL.
- Created and tested `/api/database`.

## 31 October 2026 — Swagger and Verification

- Added Swagger / OpenAPI integration.
- Successfully accessed Swagger UI.
- Executed `/api/database` through Swagger.
- Confirmed database response.
- Started complete backend verification.

# 14. CURRENT PROJECT MILESTONE

**Completed:**

- Spring Boot project setup.
- Initial REST API development.
- React and Spring Boot integration.
- MySQL database setup and connectivity.
- SQL query execution through Spring Boot.
- Swagger integration.

**Current task:**

Complete verification of all existing APIs.

**Next major milestone:**

Implement actual MySQL CRUD operations using Spring Data JPA.

---

**Learning rule:** Work in small steps. Understand the concept, implement it, test it, and update this document before moving to the next task.

**This file is the main progress document for the Spring Boot backend.**