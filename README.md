# Documentation for Library Management System API

This documentation will guide you through setting up and running the Library Management System API, interacting with API endpoints, and using authentication if implemented.

# Prerequisites

Java 11 or higher
Maven 3.6 or higher

# Setup

## Clone the Repository

git clone https://github.com/SamuelPaschalson/management-system.git <br>
cd library-management-system

## Build the Project

### Using maven

```bash
mvn clean install
```

### Using gradle

```bash
./gradlew clean build
```

## Run the Application

### using maven

```js
mvn spring-boot:run
```

### using gradle

```js
./gradlew bootRun
```

The application will start on http://localhost:8080.

## API Endpoints

### Book Endpoints

Get All Books

```http
GET /api/books;
```

Response

```json
[
	{
		"id": 1,
		"title": "Book Title",
		"author": "Author Name",
		"publicationYear": 2021,
		"isbn": "1234567890"
	}
]
```

Get Book by ID

```http
GET /api/books/{id}
```

Response

```json
{
	"id": 1,
	"title": "Book Title",
	"author": "Author Name",
	"publicationYear": 2021,
	"isbn": "1234567890"
}
```

Create A Book

```http
POST /api/books
Content-Type: application/json

{
  "title": "New Book",
  "author": "New Author",
  "publicationYear": 2022,
  "isbn": "0987654321"
}
```

Response

```json
{
	"id": 2,
	"title": "New Book",
	"author": "New Author",
	"publicationYear": 2022,
	"isbn": "0987654321"
}
```

Update a book

```http
PUT /api/books/{id}
Content-Type: application/json

{
  "title": "Updated Book",
  "author": "Updated Author",
  "publicationYear": 2022,
  "isbn": "1122334455"
}
```

Response

```json
{
	"id": 1,
	"title": "Updated Book",
	"author": "Updated Author",
	"publicationYear": 2022,
	"isbn": "1122334455"
}
```

Delete a Book

```http
DELETE /api/books/{id}
```

Response

```http
HTTP/1.1 204 No Content
```

### Patron Endpoints

Get All Patrons

```http
GET /api/patrons
```

Response

```json
[
	{
		"id": 1,
		"name": "Patron Name",
		"contactInfo": "Contact Information"
	}
]
```

Get Patron by ID

```http
GET /api/patrons/{id}
```

Response

```json
{
	"id": 1,
	"name": "Patron Name",
	"contactInfo": "Contact Information"
}
```

Create a Patron

```http
POST /api/patrons
Content-Type: application/json

{
  "name": "New Patron",
  "contactInfo": "New Contact Info"
}
```

Response

```json
{
	"id": 2,
	"name": "New Patron",
	"contactInfo": "New Contact Info"
}
```

Update a Patron

```http
PUT /api/patrons/{id}
Content-Type: application/json

{
  "name": "Updated Patron",
  "contactInfo": "Updated Contact Info"
}
```

Response

```json
{
	"id": 1,
	"name": "Updated Patron",
	"contactInfo": "Updated Contact Info"
}
```

Delete a Patron

```http
DELETE /api/patrons/{id}
```

Response

```http
HTTP/1.1 204 No Content
```

### Borrowing Record Endpoints

Borrow a Book

```http
POST /api/borrowing-records
Content-Type: application/json

{
  "bookId": 1,
  "patronId": 1,
  "borrowingDate": "2023-05-01"
}
```

Response

```json
{
	"id": 1,
	"book": {
		"id": 1,
		"title": "Book Title"
	},
	"patron": {
		"id": 1,
		"name": "Patron Name"
	},
	"borrowingDate": "2023-05-01",
	"returnDate": null
}
```

Return a Book

```http
PUT /api/borrowing-records/{id}/return
Content-Type: application/json

"2023-05-10"
```

Response

```json
{
	"id": 1,
	"book": {
		"id": 1,
		"title": "Book Title"
	},
	"patron": {
		"id": 1,
		"name": "Patron Name"
	},
	"borrowingDate": "2023-05-01",
	"returnDate": "2023-05-10"
}
```

## Running the Tests

To run the tests, you can use your IDE or run the following commands from the command line:

### For Maven:

```bash
mvn test
```

### For Gradle

```bash
./gradlew test
```
