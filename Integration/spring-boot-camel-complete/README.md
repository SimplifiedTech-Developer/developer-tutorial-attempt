## Spring Boot Camel

This module contains articles about Spring Boot with Apache Camel. This is an example Apache Camel Spring Boot project that demonstrates routing, components, and processing of messages.

## Project Structure

- `src/main/java/com.example.camel`: This directory contains the Java source code for the project.
    - `CamelApplication.java`: The main class of the project responsible for starting the Spring Boot application and configuring Camel.
    - `routes`: Contains the route builders that define the message flows in the Camel application.
    - `processors`: Contains the Camel processors that implement the logic for processing messages.
- `src/main/resources/application.properties`: The configuration properties file for the Spring Boot application.
- `src/test`: Contains the unit tests for the project.
- `pom.xml`: The Maven project object model file that defines the dependencies and build process.
- `Dockerfile`: Used to build a Docker image for the application.

## Getting Started

To run the project, follow these steps:

1. Ensure you have Java and Maven installed.
2. Clone this repository.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.
5. Send a message to the application using the provided APIs.

## Dependencies

The project uses the following dependencies:

- Apache Camel: 3.11.1
- Spring Boot: 2.5.0
- ActiveMQ Broker: 5.16.3
- HSQLDB: 2.5.1

The dependencies are managed using Maven and can be found in the `pom.xml` file.

## Usage

The project demonstrates basic routing, components, and message processing using Apache Camel and Spring Boot. It includes a sample route (`MyRouteBuilder`) that reads messages from a queue, processes them using a processor (`MyProcessor`), and inserts them into a database.

To test the solution, send a JSON message to the `myqueue` ActiveMQ queue. The message will be processed by the route and inserted into the database.

You can also customize and extend the project according to your specific requirements.

## Contributing

Contributions are welcome! If you find any issues or want to add new features, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

### Example for the Article on Camel API with SpringBoot

To start, run:

`mvn spring-boot:run`
	
Then, make a POST http request to:

`http://localhost:8080/camel/api/bean` 

Include the HEADER: Content-Type: application/json, 

and a BODY Payload like:

`{"id": 1,"name": "World"}`

We will get a return code of 201 and the response: `Hello, World` - if the transform() method from Application class is uncommented and the process() method is commented

or return code of 201 and the response: `{"id": 10,"name": "Hello, World"}` - if the transform() method from Application class is commented and the process() method is uncommented 

## Relevant articles:

- [Apache Camel with Spring Boot](https://www.baeldung.com/apache-camel-spring-boot)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.11/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.11/maven-plugin/reference/html/#build-image)