# Documentation for Library Management System

## Project Overview

The Library Management System API is built using Spring Boot. It allows librarians to manage books, patrons, and borrowing records efficiently.

## Setup Instructions

### Database Setup

1. **Create a Database**:
   - Use MySQL to create a new database for the project.

2. **Configure Database Credentials**:
   - Edit the `application.properties` file located in `src/main/resources` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_database_username
     spring.datasource.password=your_database_password
     ```
   - Ensure the MySQL server is running and the specified database is created.

### Running the Application

1. **Install JDK**:
   - Ensure you have JDK 11 or later installed.

2. **Import Project into Eclipse**:
   - Open Eclipse IDE.
   - Go to `File` > `Import`.
   - Select `Maven` > `Existing Maven Projects` and click `Next`.
   - Browse to the project directory and click `Finish`.

3. **Run the Application**:
   - Locate `MaidsLibraryManagementSystemApplication.java` in the `com.maids_library_management_system` package.
   - Right-click on `MaidsLibraryManagementSystemApplication.java` and select `Run As` > `Java Application`.
   - The application will start, and the API will be available at `http://localhost:8080`.
  
## Security Authorization

### Default Credentials

For development purposes, Spring Boot generates a default security password. The default username is `user`, and the password is dynamically generated every time the application is started.

### Authentication Required

Before accessing any API endpoint, you need to authenticate using a username and password.

### Making Authenticated Requests Using Postman

1. Open Postman and go to the **Authorization** tab.
2. Select **Basic Auth** from the **Type** dropdown menu.
3. Enter the username `user` and the provided password.

## API Endpoints

### Book Management Endpoints

- **Retrieve all books**:
  - `GET /api/books`
  - **Response**: A list of `BookDto` objects.

- **Retrieve a specific book by ID**:
  - `GET /api/books/{id}`
  - **Response**: A `BookDto` object.

- **Add a new book**:
  - `POST /api/books`
  - **Request Body**:
    ```json
    {
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "publicationYear": 1925,
      "isbn": "9780743273565"
    }
    ```
  - **Response**: The created `BookDto` object with its ID.

- **Update an existing book's information**:
  - `PUT /api/books/{id}`
  - **Request Body**:
    ```json
    {
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "publicationYear": 1925,
      "isbn": "9780743273565"
    }
    ```
  - **Response**: The updated `BookDto` object.

- **Remove a book**:
  - `DELETE /api/books/{id}`
  - **Response**: A confirmation message or status.

### Patron Management Endpoints

- **Retrieve all patrons**:
  - `GET /api/patrons`
  - **Response**: A list of `PatronDto` objects.

- **Retrieve a specific patron by ID**:
  - `GET /api/patrons/{id}`
  - **Response**: A `PatronDto` object.

- **Add a new patron**:
  - `POST /api/patrons`
  - **Request Body**:
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "phoneNumber": "1234567890"
    }
    ```
  - **Response**: The created `PatronDto` object with its ID.

- **Update an existing patron's information**:
  - `PUT /api/patrons/{id}`
  - **Request Body**:
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "phoneNumber": "1234567890"
    }
    ```
  - **Response**: The updated `PatronDto` object.

- **Remove a patron**:
  - `DELETE /api/patrons/{id}`
  - **Response**: The created `BorrowingRecordDto` object with its ID.

### Borrowing Endpoints

- **Allow a patron to borrow a book**:
  - `POST /api/borrow/{bookId}/patron/{patronId}`
  - **Response**: The created BorrowingRecordDto object with its ID.

- **Record the return of a borrowed book**:
  - `POST /api/return/{bookId}/patron/{patronId}`
  - **Response**: The updated BorrowingRecordDto object with its ID.

## Data Storage

- The application uses MySQL to persist data.
- Relationships between entities:
  - **Books** and **Borrowing Records**: One-to-many relationship.
  - **Patrons** and **Borrowing Records**: One-to-many relationship.

## Validation and Error Handling

- Input validation is implemented to ensure correct data formats and required fields.
- Exceptions are handled gracefully with appropriate HTTP status codes and error messages.

## Transaction Management

- Declarative transaction management with Spring's `@Transactional` annotation.

## Testing

- Unit tests are written to validate API functionality.
- Testing frameworks used: Mockito, and SpringBootTest.
