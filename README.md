# Car CRUD API - Java 17 & Spring Boot 3

## **Project Description**
This is a **Java 17** and **Spring Boot 3** project using **Maven**, which consists of a **CRUD Rest API** for managing cars and their associated drivers. It leverages **MongoDB** as the database.

## Installation Requirements
To install and run this project, ensure you have the following tools installed:

- **MongoDB**

- **Java 17**

- **Maven**

- **Spring Boot 3**

- **API Client (e.g., Postman)**


## Project Setup & Usage
This API provides CRUD (Create, Read, Update, Delete) operations for managing cars. Each car entry contains:

- **ID**

- **Brand**

- **Model**

- **Pilot**: with **name** and **age**

- **Year**: the car's manufacturing date

### **Important Constraints**:
- You cannot create cars with the same **Brand** and **Model**.
- A single pilot cannot be associated with more than one car.

## Endpoints Overview
### 1. Create a Car (POST Request)
URL:
`localhost:8080/ms-cars/`

**Request Body (JSON format):**

```json
{
  "brand": "BMW",
  "model": "X1",
  "pilot": {
    "name": "Peter Josh",
    "age": 21
  },
  "year": "2022-03-03"
}
```

### 2. Retrieve All Cars (GET Request)
URL: `localhost:8080/ms-cars/`

**Sample Response**:

```json
{
  "id": "6053dfgn235jcff012m",
  "brand": "BMW",
  "model": "X1",
  "pilot": {
    "name": "Peter Josh",
    "age": 21
  },
  "year": "2022-03-03"
}
```

### 3. Update a Car (PUT Request)
URL: `localhost:8080/ms-cars/{id}`

### 4. Delete a Car (DELETE Request)
URL: `localhost:8080/ms-cars/{id}`




