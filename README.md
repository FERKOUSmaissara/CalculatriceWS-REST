# CalculatriceWS-REST

REST Web Service project using Java, Jersey and Tomcat.

## Features

- **Calculatrice** REST API — arithmetic operations (add, subtract, multiply, divide) returning results in **text**, **XML**, or **HTML** depending on the `Accept` header.
- **TODO** REST API — full CRUD operations with **JSON** support.

## Project Structure

```
src/
  main/
    java/com/calculatrice/
      CalculatriceResource.java   # Calculator REST resource
      Todo.java                   # TODO model
      TodoService.java            # In-memory TODO storage
      TodoResource.java           # TODO REST resource
    webapp/WEB-INF/
      web.xml                     # Jersey servlet configuration
  test/java/com/calculatrice/
    CalculatriceResourceTest.java
    TodoResourceTest.java
pom.xml
```

## Build & Deploy

```bash
# Build WAR
mvn clean package

# Run tests
mvn test

# Deploy target/CalculatriceWS-REST.war to Tomcat 9
```

## API Endpoints

### Calculatrice — `/api/calculatrice`

| Method | Path                           | Accept Header | Description        |
|--------|--------------------------------|---------------|--------------------|
| GET    | `/add/{a}/{b}`                 | text/plain    | Addition (text)    |
| GET    | `/add/{a}/{b}`                 | text/xml      | Addition (XML)     |
| GET    | `/add/{a}/{b}`                 | text/html     | Addition (HTML)    |
| GET    | `/subtract/{a}/{b}`            | text/plain    | Subtraction        |
| GET    | `/multiply/{a}/{b}`            | text/plain    | Multiplication     |
| GET    | `/divide/{a}/{b}`              | text/plain    | Division           |

### TODO — `/api/todos`

| Method | Path           | Description           |
|--------|----------------|-----------------------|
| GET    | `/`            | List all todos        |
| GET    | `/{id}`        | Get todo by id        |
| POST   | `/`            | Create a new todo     |
| PUT    | `/{id}`        | Update a todo         |
| DELETE | `/{id}`        | Delete a todo         |

#### Example JSON body (POST/PUT)

```json
{
  "titre": "Mon todo",
  "description": "Détails du todo",
  "complete": false
}
```
