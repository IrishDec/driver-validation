# Driver Validation API

Proof of concept Kotlin and Spring Boot API for driver document validation.

## What it does

This project simulates a small backend service for driver document validation.

It currently includes:

- health check endpoint
- driver document endpoint
- simple business rule to reject expired documents
- clean package structure with controller, service, and model layers

## Tech stack

- Kotlin
- Spring Boot
- Gradle

## Endpoints

### Health check

`GET /api/health`

Response:

`Driver Validation API is running`

### Driver documents

`GET /api/driver-documents?fileName=taxi-license.pdf`

Example response:

```json
{
  "id": 1,
  "fileName": "taxi-license.pdf",
  "status": "PENDING"
}
