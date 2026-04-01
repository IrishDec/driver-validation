# Driver Validation API

Proof of concept Kotlin and Spring Boot API for driver document validation, now connected to a simple frontend demo UI.

## What it does

This project simulates a small backend service for driver document validation and displays results through a simple frontend interface.

It currently includes:

- health check endpoint
- driver document validation endpoint
- simple business rule to reject expired documents
- H2 in-memory database persistence
- Spring Data JPA repository layer
- frontend demo UI connected to the backend
- clean package structure with controller, service, model, and repository layers

## Frontend demo

A simple Next.js frontend is connected to the backend and allows a user to:

- enter a driver id
- enter a file name
- submit a validation request
- view the saved result returned from the API

## Tech stack

- Kotlin
- Spring Boot
- Spring Data JPA
- H2 Database
- Gradle
- Next.js
- TypeScript
- Tailwind CSS

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

GET /api/driver-documents?driverId=123&fileName=expired-license.pdf

```json
{
  "id": 2,
  "driverId": "123",
  "fileName": "expired-license.pdf",
  "status": "REJECTED",
  "rejectionReason": "Document is expired"
}
```
Current business rule
if the file name contains expired, the document is marked as REJECTED
otherwise, the document is marked as PENDING
Database
```
This project uses an H2 in-memory database so it can be reviewed and run locally without external database setup.
```
The API persists driver document records including:

generated id
driver id
file name
document status
rejection reason
Demo screenshots
Frontend demo - rejected document
frontend-rejected.png

Frontend demo - pending document
frontend-pending.png

H2 console login
H2 console login

H2 console opened
H2 console opened

H2 persisted record
H2 persisted record


