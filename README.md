# 🚀 Digital Heroes - Internship Qualification Task (Task B)

A robust backend tool built with Java and Spring Boot, designed to handle data parsing, validation, and API processing defensibly and reliably.

---

## 🛠️ Setup & Installation

### Prerequisites
- **Java**: JDK 21 or higher
- **Build Tool**: Apache Maven 3.8+ (or included Maven Wrapper `./mvnw`)
- **Port**: 8081 (default)

### 1. Clone the Repository
```bash
git clone https://github.com/raginiyadav529/PAGEPULSE
cd digital-heroes-task
```

### 2. Build the Project
Compile the code and execute unit tests:
```bash
./mvnw clean package
```

### 3. Run the Application
Start the Spring Boot application locally:
```bash
./mvnw spring-boot:run
```
The server will start at `http://localhost:8081`.

### 4. Run Tests
To run the automated test suite (including happy paths and failure test cases):
```bash
./mvnw test
```

---

## 📜 API Contract

### Base URL
`http://localhost:8081/`

---

### Endpoint 1: Parse Data / Process Payload

* **URL:** `/parse`
* **Method:** `POST`
* **Content-Type:** `application/json`

#### Request Body
```json
{
  "rawInput": "sample_input_string_to_parse",
  "options": {
    "strictMode": true
  }
}
```

#### Success Response (`200 OK`)
```json
{
  "success": true,
  "status": "PROCESSED",
  "result": {
    "parsedFields": [
      {
        "key": "sample_input",
        "value": "parsed_value"
      }
    ]
  },
  "timestamp": "2026-07-25T15:30:00Z"
}
```

#### Error Response — Malformed Input (`400 Bad Request`)
```json
{
  "success": false,
  "errorCode": "PARSE_ERROR_INVALID_FORMAT",
  "message": "Input data is malformed or unparseable.",
  "timestamp": "2026-07-25T15:30:00Z"
}
```

#### Error Response — Empty/Missing Payload (`422 Unprocessable Entity`)
```json
{
  "success": false,
  "errorCode": "VALIDATION_FAILED",
  "message": "Required field 'rawInput' cannot be null or empty.",
  "timestamp": "2026-07-25T15:30:00Z"
}
```

---

## 💡 Key Design Decisions & Reasoning

### 1. Framework Choice: Spring Boot

* **Reasoning:** Spring Boot provides a production‑ready environment with minimal configuration. It simplifies REST API development, integrates seamlessly with testing frameworks, and is widely used in industry — making the project realistic and scalable.
### 2. Error Handling with Structured JSON

* **Reasoning:** Instead of returning plain text errors, the API always responds with JSON objects containing status and error fields. This ensures consistency for frontend consumers, improves developer experience, and makes debugging easier.
### 3. Testing Strategy with JUnit + Spring Boot Test

* **Reasoning:** Automated tests validate core functionality (valid URL, invalid URL, timeout). This improves reliability, prevents regressions, and demonstrates good engineering practices expected in real‑world projects.

---

## 📌 Credit Notice
Built for Digital Heroes Training Task: [digitalheroesco.com](https://digitalheroesco.com)
