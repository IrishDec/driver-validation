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

### Driver documents

`GET /api/driver-documents?driverId=123&fileName=taxi-license.pdf`

Example response:

```json
{
  "id": 1,
  "driverId": "123",
  "fileName": "taxi-license.pdf",
  "status": "PENDING",
  "rejectionReason": null
}
```
Rejected example:

`GET /api/driver-documents?driverId=123&fileName=expired-license.pdf`

```json
{
  "id": 2,
  "driverId": "123",
  "fileName": "expired-license.pdf",
  "status": "REJECTED",
  "rejectionReason": "Document is expired"
}
```
## Current business rule

- if the file name contains `expired`, the document is marked as `REJECTED`
- otherwise, the document is marked as `PENDING`

## Database

This project uses an H2 in-memory database so it can be reviewed and run locally without external database setup.

The API now persists driver document records, including:

- generated id
- driver id
- file name
- document status
- rejection reason

## Demo screenshots

### API response

(Add screenshot here)

### H2 console login

![H2 login](Screenshot%202026-03-31%20at%2017.57.07.png)

### H2 persisted record

![H2 persisted record](Screenshot%202026-03-31%20at%2017.53.21.png)


