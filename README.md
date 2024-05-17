# Getting Started

Shopify service is a microservice to get webhook requests from Shopify regarding product/collection creation/updates.
Service receives the data from Shopify and stores it
in the Postgres database that would then be mapped to a Nosto product and send to the Playcart.

To run the application with docker you can just run "docker compose up" within the projects directory. This will build
the application and run it within docker with the postgres instance.
Otherwise you can run postgres via docker and run the project with gradle or via intellij.

This project is using Java 21 (LTS) so you may need to downlaod the JDK (this is doable via IntelliJ).

### Useful to know

Project has Liquibase for database migrations. If you want to create a new table or change the database structure
you would need to create a new SQL file within resources->db.changelog->scripts and add to master.yaml a section for a
migration

Additionally Logging framework used is Logback and you can change the settings of the format or where to log within the
logback.xml within the resources->logback.xml

For any global exception handling please use GlobalExceptionHandler within config package to catch the exceptions and to
gracefully return the error to the user.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/gradle-plugin/reference/html/#build-image)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.liquibase)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#actuator)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* shopify-service: [`shopify-service:latest`]





