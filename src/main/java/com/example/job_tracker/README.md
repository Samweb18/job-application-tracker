# Job Application Tracker

A Spring Boot REST API for managing job applications. It allows users to create, view, update, delete, and search applications, and view application statistics by status.

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Bean Validation
* Postman

## Features

* Add, view, update, and delete job applications
* Search applications by company name
* Track application status
* View application statistics
* Validate incoming request data
* Handle missing application IDs

## Application Statuses

* APPLIED
* ASSESSMENT
* INTERVIEW
* OFFER
* REJECTED
* WITHDRAWN

## API Endpoints

| Method | Endpoint                               | Description              |
| ------ | -------------------------------------- | ------------------------ |
| POST   | `/applications`                        | Create an application    |
| GET    | `/applications`                        | Get all applications     |
| GET    | `/applications/{id}`                   | Get an application by ID |
| PUT    | `/applications/{id}`                   | Update an application    |
| DELETE | `/applications/{id}`                   | Delete an application    |
| GET    | `/applications/search?company=Infosys` | Search by company        |
| GET    | `/applications/statistics`             | Get counts by status     |

## Setup

1. Clone the repository.
2. Create a MySQL database named `job_tracker`.
3. Configure the database URL, username, and password in `application.properties`.
4. Run the application using IntelliJ or Maven.

## Future Improvements

* Add a frontend
* Add filtering and sorting
* Deploy the application
