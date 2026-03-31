# Driver Validation API

Proof of concept Kotlin and Spring Boot API for driver document validation.

## What it does

This project simulates a small backend service for driver document validation.

It currently includes:

- health check endpoint
- driver document validation endpoint
- simple business rule to reject expired documents
- H2 in-memory database persistence
- Spring Data JPA repository layer
- clean package structure with controller, service, model, and repository layers

## Tech stack

- Kotlin
- Spring Boot
- Spring Data JPA
- H2 Database
- Gradle

## Endpoints

### Health check

`GET /api/health`

Response:

`Driver Validation API is running`

