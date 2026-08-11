# Spring Boot Cloudinary File Upload API

A Spring Boot REST API that demonstrates how to upload files to **Cloudinary**, store the uploaded file URL in a database using **Spring Data JPA**, and expose the functionality through a REST endpoint.

## Features

* Spring Boot REST API
* Cloudinary integration for file/image storage
* Multipart file upload
* Automatic Cloudinary URL generation
* MySQL/JPA database integration
* Product entity with stored Cloudinary URL
* Repository layer using Spring Data JPA
* Lombok for reducing boilerplate code
* Basic Student entity and repository structure

## Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Cloudinary**
* **Lombok**
* **Maven**

## Project Structure

```text
src/
└── main/
    ├── java/
    │   └── new_spring_project/
    │       └── second_project/
    │           ├── config/
    │           │   └── CloudinaryConfig.java
    │           │
    │           ├── controller/
    │           │   └── ProductController.java
    │           │
    │           ├── entity/
    │           │   ├── Products.java
    │           │   └── Student.java
    │           │
    │           ├── repository/
    │           │   ├── ProductRepository.java
    │           │   └── StudentRepository.java
    │           │
    │           ├── services/
    │           │   ├── ProductService.java
    │           │   └── StudentService.java
    │           │
    │           └── SecondProjectApplication.java
    │
    └── resources/
        └── application.properties
```

## How It Works

The application follows a simple layered architecture:

```text
Client
  │
  │  GET /product
  │  name + file
  ▼
ProductController
  │
  ▼
ProductService
  │
  ├── Upload file
  │      │
  │      ▼
  │   Cloudinary
  │      │
  │      ▼
  │   File URL
  │
  ▼
ProductRepository
  │
  ▼
Database
```

When a client sends a product name and file:

1. `ProductController` receives the request.
2. `ProductService` sends the file to Cloudinary.
3. Cloudinary uploads the file and returns its URL.
4. The application creates a `Products` object.
5. The product name and Cloudinary URL are stored in the database.
6. The saved product is returned as the API response.

## Cloudinary Configuration

The `CloudinaryConfig` class creates a Cloudinary bean using credentials from `application.properties`.

Example:

```properties
cloudinary.cloud_name=YOUR_CLOUD_NAME
cloudinary.api_key=YOUR_API_KEY
cloudinary.api_secret=YOUR_API_SECRET
```

Do not commit real Cloudinary credentials to GitHub.

For production or public repositories, use environment variables instead of hardcoding credentials.

## Database Configuration

Example MySQL configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/second_project
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Adjust the database name, username, and password according to your local setup.

## API Endpoint

### Upload Product

**Endpoint:**

```text
GET /product
```

### Parameters

| Parameter | Type          | Description          |
| --------- | ------------- | -------------------- |
| `name`    | String        | Product name         |
| `file`    | MultipartFile | Image/file to upload |

### Example Request

Using Postman:

```text
GET http://localhost:8080/product?name=Laptop
```

In the `Params` section:

```text
name = Laptop
```

In the request body, select:

```text
form-data
```

and add:

```text
file = <select your image/file>
```

### Example Response

```json
{
  "id": 1,
  "name": "Laptop",
  "url": "https://res.cloudinary.com/your-cloud-name/image/upload/..."
}
```

## Product Entity

The `Products` entity contains three main fields:

```text
id
name
url
```

The `url` field stores the URL returned by Cloudinary after successful upload.

Example database record:

| id | name   | url            |
| -: | ------ | -------------- |
|  1 | Laptop | Cloudinary URL |
|  2 | Mobile | Cloudinary URL |

## Student Module

The project also contains a basic `Student` entity and `StudentRepository`.

The Student entity contains:

```text
id
name
rollno
marks
```

The repository extends:

```java
JpaRepository<Student, Long>
```

A `StudentService` interface has also been created as the starting point for implementing student-related business logic.

## Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/spring-boot-cloudinary-file-upload-api.git
```

### 2. Open the project

Open the project in:

* Eclipse
* IntelliJ IDEA
* Spring Tool Suite
* VS Code

### 3. Configure MySQL

Create the required database:

```sql
CREATE DATABASE second_project;
```

Then configure the database credentials in `application.properties`.

### 4. Configure Cloudinary

Add your Cloudinary credentials to the application configuration.

```properties
cloudinary.cloud_name=YOUR_CLOUD_NAME
cloudinary.api_key=YOUR_API_KEY
cloudinary.api_secret=YOUR_API_SECRET
```

### 5. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run `SecondProjectApplication.java` directly from Eclipse/IntelliJ.

The application will normally start at:

```text
http://localhost:8080
```

## Important Security Note

Never upload sensitive credentials to GitHub.

Avoid committing:

```properties
cloudinary.api_secret=actual-secret
spring.datasource.password=actual-password
```

Instead, use environment variables or a local configuration file that is excluded through `.gitignore`.

## Future Improvements

The project can be extended with:

* POST instead of GET for file uploads
* Product CRUD operations
* Student CRUD operations
* DTOs and validation
* Global exception handling
* Proper HTTP status responses
* Delete files from Cloudinary
* Update product images
* Pagination and sorting
* Swagger/OpenAPI documentation
* Authentication and authorization
* Cloudinary folder management
* Unit and integration testing

## Learning Objectives

This project demonstrates practical usage of:

* Spring Boot dependency injection
* `@Configuration` and `@Bean`
* `@Value`
* REST controllers
* Multipart file handling
* Service-layer architecture
* Spring Data JPA
* Hibernate
* Entity mapping
* Repository abstraction
* Third-party API integration
* Cloudinary file storage
* Database persistence

## Author

**Ayush Sharma**

B.Tech Computer Science & Engineering

---

If you found this project useful, consider giving the repository a star.
