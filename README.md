# JobListingApplication

## Description
The Job Listing Application is a simple Spring Boot-based web service that allows users to post job listings and search for jobs based on specific criteria. The project uses **MongoDB** for data storage and integrates **Spring Data MongoDB** for database interaction. The search functionality allows users to query job posts using full-text search on fields such as profile, description, and technologies used in the job listings.

The application also integrates **Swagger UI** to provide interactive documentation for the API.

## Features
- **Create Job Post**: Allows users to create job postings with details like profile, description, required experience, and technologies.
- **Search Jobs**: Full-text search for job postings by entering keywords related to profile, description, or technologies.
- **Swagger UI Integration**: The API can be explored interactively through Swagger UI.

## Technologies Used
- **Spring Boot**: A Java framework used to build the application and handle all backend operations (web, database, etc.).
- **MongoDB**: A NoSQL database used for storing job posts.
- **Spring Data MongoDB**: Provides integration between Spring Boot and MongoDB for easier data management and querying.
- **Springdoc OpenAPI**: Generates Swagger UI documentation for the RESTful APIs.
- **Maven**: A build automation tool used to manage dependencies and build the project.
- **Java 21**: The programming language used for the backend application.

## Setup Instructions

### Prerequisites
- JDK 21 or higher installed on your system.
- Maven installed on your machine for building the project.
- A **MongoDB Atlas** account and a MongoDB Cluster setup (or any local MongoDB setup).

### 1. Clone the Repository
Clone the project to your local machine:

```bash
git clone https://github.com/yourusername/joblisting.git
```

### 2. Set Up MongoDB
Ensure you have a MongoDB database available. You can use **MongoDB Atlas** to set up a cloud-based MongoDB instance or run MongoDB locally.

Update the `application.properties` file with your MongoDB connection string:

```properties
spring.data.mongodb.uri=mongodb+srv://<your-username>:<your-password>@<cluster-name>.mongodb.net/?retryWrites=true&w=majority&appName=JobPortal
spring.data.mongodb.database=JobPortal

```

## Build the Project
Navigate to the project directory and run the following Maven command to build the project:

```bash
mvn clean install
```
## 4. Run the Application
After building the project, you can run it with:
```bash
mvn spring-boot:run
```
The application will start on  http://localhost:8080.

## 5. Access the API Documentation
Once the application is running, you can view the Swagger UI documentation by visiting:
```bash
http://localhost:8080/swagger-ui.html
```


## API Endpoints

### 1. Get All Job Posts
- **URL**: `/posts`
- **Method**: `GET`
- **Description**: Fetches all the job posts available in the system.

### 2. Search Job Posts
- **URL**: `/posts/{text}`
- **Method**: `GET`
- **Description**: Search job posts by entering text (e.g., "Java Developer") to search in profile, description, or technologies.
- **Example**: `/posts/Java`

### 3. Create a Job Post
- **URL**: `/post`
- **Method**: `POST`
- **Description**: Allows creating a new job post with the profile, description, experience, and technologies.
- **Request Body**:
  
```json
{
  "profile": "Java Developer",
  "desc": "Responsible for developing backend services.",
  "exp": 3,
  "techs": ["Java", "Spring Boot", "MongoDB"]
}
```

## Tools and Libraries Used

- **Spring Boot**: The main framework used to build the RESTful backend service.
- **MongoDB**: The database used to store job posts. MongoDB's flexible document structure allows easy scaling and flexible data modeling.
- **Spring Data MongoDB**: Simplifies the interaction between Spring Boot and MongoDB, providing a repository layer for easy querying and saving of documents.
- **Springdoc OpenAPI**: Automatically generates API documentation and serves it using Swagger UI, making it easy for developers to test and explore the API.
- **Maven**: Used for managing project dependencies and building the application.
- **Java 21**: Used as the programming language for this project.

## Contributing

We welcome contributions! If you want to improve the project or add new features, please follow the steps below:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make the necessary changes or additions.
4. Commit the changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a Pull Request from your forked repository.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Authors

- **Your Name** - Developer  
  Email: [your.email@example.com](mailto:your.email@example.com)

## Acknowledgements

- **MongoDB**: For its flexible document-based database that simplifies storage and querying.
- **Spring Boot**: For making backend development faster and easier.
- **Swagger UI**: For providing interactive API documentation and making it easier to explore the APIs.

