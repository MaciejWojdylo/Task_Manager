# Task Manager API

## Opis projektu / Project Description

Projekt `Task Manager` jest aplikacją webową umożliwiającą zarządzanie zadaniami. Implementuje operacje CRUD na zadaniach oraz dokumentację API za pomocą Swagger UI. Aplikacja wykorzystuje Spring Boot, Kotlin, Spring Data JPA oraz Spring Security.

The `Task Manager` project is a web application that allows task management. It implements CRUD operations on tasks and provides API documentation via Swagger UI. The application uses Spring Boot, Kotlin, Spring Data JPA, and Spring Security.

## Spis Treści / Table of Contents

1. **Opis projektu / Project Description**
2. **Technologie / Technologies**
3. **Instalacja / Installation**
4. **Endpointy API / API Endpoints**
5. **Dokumentacja API / API Documentation**
6. **Przyszłe zmiany / Future Changes**

## Technologie / Technologies

- **Spring Boot** - Framework do tworzenia aplikacji webowych.
- **Spring Data JPA** - Ułatwia interakcję z bazą danych.
- **Kotlin** - Język programowania użyty do implementacji.
- **Swagger** (Springdoc OpenAPI) - Dokumentacja API.
- **JUnit5 & Mockk** - Testowanie jednostkowe i mockowanie w Kotlinie.
- **Spring Security** - Zapewnienie bezpieczeństwa aplikacji.
- **PostgreSQL / H2** - Baza danych.

- **Spring Boot** - A framework for building web applications.
- **Spring Data JPA** - Simplifies interaction with databases.
- **Kotlin** - The programming language used for implementation.
- **Swagger** (Springdoc OpenAPI) - API documentation.
- **JUnit5 & Mockk** - Unit testing and mocking in Kotlin.
- **Spring Security** - Provides application security.
- **PostgreSQL / H2** - Database.

## Instalacja / Installation

Aby uruchomić projekt, musisz mieć zainstalowane:

- [Java 17+](https://adoptopenjdk.net/)
- [Gradle](https://gradle.org/install/) (chociaż Gradle Wrapper jest również dostępny w projekcie)

### Klonowanie repozytorium / Clone the repository

```bash
git clone https://github.com/MaciejWojdylo/task-manager.git
cd task-manager
```

## Instalacja zależności / Install dependencies
```
./gradlew build
```

## Uruchamianie aplikacji / Running the application
```
./gradlew bootRun
```
Aplikacja będzie dostępna pod adresem: http://localhost:8080
The application will be available at: http://localhost:8080

Endpointy API / API Endpoints
GET /tasks
Zwraca listę wszystkich zadań.
Response:
Status: 200 OK
Body: Lista zadań (w formacie JSON)
Returns a list of all tasks.
Response:
Status: 200 OK
Body: List of tasks (in JSON format)

GET /tasks/{id}
Zwraca zadanie o podanym id.
Response:
Status: 200 OK (jeśli zadanie istnieje)
Status: 404 Not Found (jeśli zadanie nie istnieje)
Body: Zadanie w formacie JSON
Returns a task with the given id.

Response:
Status: 200 OK (if the task exists)
Status: 404 Not Found (if the task does not exist)
Body: Task in JSON format

POST /tasks
Tworzy nowe zadanie.
Request:
Body: Obiekt zadania w formacie JSON

Response:
Status: 201 Created
Body: Nowo utworzone zadanie w formacie JSON
Creates a new task.
Request:
Body: Task object in JSON format

Response:
Status: 201 Created
Body: Newly created task in JSON format
PUT /tasks/{id}
Aktualizuje zadanie o podanym id.

Request:
Body: Zaktualizowane zadanie w formacie JSON

Response:
Status: 200 OK (jeśli zadanie zostało zaktualizowane)
Status: 404 Not Found (jeśli zadanie nie istnieje)
Body: Zaktualizowane zadanie w formacie JSON
Updates the task with the given id.
Request:
Body: Updated task in JSON format

Response:
Status: 200 OK (if the task was updated)
Status: 404 Not Found (if the task does not exist)
Body: Updated task in JSON format
DELETE /tasks/{id}
Usuwa zadanie o podanym id.

Response:
Status: 204 No Content (jeśli zadanie zostało usunięte)
Status: 404 Not Found (jeśli zadanie nie istnieje)
Deletes the task with the given id.

Response:
Status: 204 No Content (if the task was deleted)
Status: 404 Not Found (if the task does not exist)


Dokumentacja API / API Documentation
Wszystkie dostępne endpointy oraz ich szczegóły są dostępne w dokumentacji API, która jest dostępna pod adresem:
http://localhost:8080/swagger-ui/index.html

All available endpoints and their details are available in the API documentation, accessible at:
http://localhost:8080/swagger-ui/index.html

Przyszłe zmiany / Future Changes
1. Obsługa wyjątków:
Obecnie aplikacja rzuca wyjątek 404, gdy zadanie nie jest znalezione. Planuje dodać lepszą obsługę wyjątków, aby zwrócić bardziej szczegółowe informacje o błędach.

2. Autentykacja i autoryzacja (JWT & Spring Security):
Implementacja JWT (JSON Web Token) dla bezpieczeństwa API. Użytkownicy będą musieli się zalogować, aby uzyskać dostęp do endpointów API.
Wdrożenie Spring Security, aby zapewnić odpowiednią autoryzację i autentykację dla użytkowników.

4. Baza danych:
Obecnie aplikacja korzysta z bazy H2, ale planujemy przejść na bazę PostgreSQL w przyszłości.
Dodatkowe migracje dla bazy danych, które pozwolą na łatwe zarządzanie strukturą danych.

4. Frontend (React lub Kotlin Compose):
Planujemy stworzyć frontend aplikacji, wykorzystując Kotlin Compose lub React, aby umożliwić interakcję użytkowników z API.
Implementacja interfejsu użytkownika do zarządzania zadaniami.

6. Testy:
Rozbudowa testów jednostkowych i integracyjnych dla API.
Mockowanie danych wejściowych przy pomocy bibliotek takich jak Mockk.
