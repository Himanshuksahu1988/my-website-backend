# Spring Boot Backend — Project Progress

Last updated: 15 October 2026

## Goal

Build the Spring Boot backend for the My Website project, one small step at a time, and later connect it to the React frontend and MySQL database.

## Project Details

- Project name: `my-website-backend`
- Local folder: `C:\Users\Himanshu\eclipse-workspace\my-website-backend`
- GitHub repository: https://github.com/Himanshuksahu1988/my-website-backend
- IDE: Eclipse with Spring Tools
- Language/runtime: Java 17
- Build tool: Maven
- Dependency added: Spring Web
- Application port: `8081`
- Base URL: `http://localhost:8081/`

## Completed

### Setup

- Installed Spring Tools in Eclipse.
- Created the Spring Boot Maven project `my-website-backend`.
- Added the Spring Web dependency.
- Configured `server.port=8081` in `src/main/resources/application.properties` because port 8080 was already in use.
- Started the Spring Boot application successfully.

### First REST API

- Created `HelloController.java`.
- Used `@RestController` to define a REST controller.
- Used `@GetMapping("/")` to map a GET request to the root path.
- Tested `GET http://localhost:8081/` in Postman.
- Confirmed the response was `200 OK`, with body:
  `Hello from spring boot`

### Git and GitHub

- Created the GitHub repository:
  https://github.com/Himanshuksahu1988/my-website-backend
- Initialized Git in the local project.
- Staged the project files with `git add .`.
- Created the initial commit:
  - Commit: `a9c1118`
  - Message: `Initial Spring Boot backend project`
- Added the remote named `origin`.
- Renamed the branch to `main`.
- Pushed the project to GitHub.

## Important Files

- `pom.xml` — Maven project configuration and dependencies.
- `src/main/java/com/example/mywebsitebackend/MyWebsiteBackendApplication.java` — Spring Boot application entry point.
- `src/main/java/com/example/mywebsitebackend/HelloController.java` — REST API controller.
- `src/main/resources/application.properties` — application configuration.
- `src/test/java/com/example/mywebsitebackend/MyWebsiteBackendApplicationTests.java` — test class.

## Current API

| Method | Endpoint | Expected response |
|---|---|---|
| GET | `http://localhost:8081/` | `Hello from spring boot` |

## Next Steps

Complete one step at a time and verify it before moving on.

1. Add a second endpoint: `GET /api/message`.
2. Test `http://localhost:8081/api/message` in Postman.
3. Commit and push the endpoint change to GitHub.
4. Learn how React calls the Spring Boot API using `fetch()`.
5. Configure CORS so `http://localhost:5173` can call `http://localhost:8081`.
6. Connect Spring Boot to MySQL.
7. Learn Docker basics for the project.
8. Explore deploying the application to AWS.

## Session Log

### 14 October 2026 — Spring Boot API

- Started the Spring Boot application on port 8081.
- Created and tested the first GET endpoint at `/`.
- Verified a `200 OK` response in Postman.

### 15 October 2026 — GitHub

- Created the `my-website-backend` GitHub repository.
- Initialized Git and committed the existing project files.
- Connected the remote and pushed the code to the `main` branch.

## Next Session

Create and test the second endpoint: `GET /api/message`.
