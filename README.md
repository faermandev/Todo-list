# Todo API

A RESTful Todo API built with Spring Boot, JPA, and an in-memory H2 database.

## Tech Stack

- Java 21
- Spring Boot 4.0.4
- Spring Data JPA
- Spring MVC
- H2 (in-memory database)
- Lombok
- Bean Validation

## Running

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

## API Endpoints

| Method | Endpoint       | Description          |
|--------|----------------|----------------------|
| POST   | `/todos`        | Create a new todo    |
| GET    | `/todos`        | List todos (paged)   |
| GET    | `/todos/{id}`   | Get a todo by ID     |
| PUT    | `/todos/{id}`   | Update a todo        |
| DELETE | `/todos/{id}`   | Delete a todo        |

### Request Body (POST / PUT)

```json
{
  "taskName": "Buy groceries"
}
```

**Validation rules:**
- `taskName` — required, minimum 3 characters

### Todo Response

```json
{
  "id": 1,
  "taskName": "Buy groceries",
  "status": "NOT_DONE",
  "createdAt": "2026-03-24T10:00:00"
}
```

### Status values

| Value      | Description        |
|------------|--------------------|
| `NOT_DONE` | Default status     |
| `DONE`     | Task completed     |

### Pagination

The `GET /todos` endpoint supports Spring's standard pagination parameters:

| Param  | Example  | Description        |
|--------|----------|--------------------|
| `page` | `0`      | Page number (0-based) |
| `size` | `10`     | Items per page     |
| `sort` | `id,asc` | Sort field and direction |

Example: `GET /todos?page=0&size=10&sort=createdAt,desc`

## Error Responses

**404 Not Found**
```json
{
  "message": "Todo not found"
}
```

**400 Bad Request (validation)**
```json
{
  "errors": {
    "taskName": "Task have at least 3 characters"
  }
}
```

## Building

```bash
./mvnw clean package
java -jar target/teste-0.0.1-SNAPSHOT.jar
```

## Testing

```bash
./mvnw test
```
