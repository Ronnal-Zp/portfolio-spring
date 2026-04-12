# Agent Guidance for Portfolio Project

This document provides high-signal guidance for future OpenCode sessions working on this project.

## Project Overview
*   **Type:** Spring Boot Application
*   **Language:** Java 21
*   **Build System:** Apache Maven

## Essential Commands

*   **Build Project:**
    ```bash
    ./mvnw clean install
    ```
*   **Run Development Server:**
    ```bash
    ./mvnw spring-boot:run
    ```
*   **Run All Tests:**
    ```bash
    ./mvnw test
    ```
*   **Run a Specific Test Class:**
    ```bash
    ./mvnw test -Dtest=<TestClassName>
    ```
    (Replace `<TestClassName>` with the fully qualified name, e.g., `com.aldahir.zamora.portfolio.MyControllerTest`)

## Key Technologies & Frameworks
*   **Web Framework:** Spring WebMVC
*   **Data Access:** Spring Data JDBC
*   **Templating Engine:** Thymeleaf
*   **Database:** PostgreSQL (runtime dependency)
*   **Code Generation/Annotations:** Lombok

## Architectural Notes
*   Standard Spring Boot project structure.
*   Source code in `src/main/java`.
*   Resources (templates, static assets, configuration) in `src/main/resources`.
*   Test code in `src/test/java`.

## Conventions & Gotchas
*   **Lombok:** Used for reducing boilerplate code (e.g., getters, setters, constructors). Ensure Lombok annotations are correctly processed during compilation.
*   **Maven Parent Overrides:** The `pom.xml` explicitly overrides `<license>` and `<developers>` elements from the Spring Boot parent to keep them empty. Do not reintroduce these unless explicitly required.
