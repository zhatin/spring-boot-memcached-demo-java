# Spring Boot Memcached Demo in Java

This is a demo project showing the usage of [Memcached Spring Boot](https://github.com/sixhours-team/memcached-spring-boot) cache library in a Spring Boot Java application.
You will have to have Docker and Java 9 installed in order to run this demo.

There is an equivalent demo project written in Kotlin. To see version of this demo in Kotlin go to [Spring Boot Memcached Demo in Kotlin](https://github.com/sixhours-team/spring-boot-memcached-demo-kotlin).

## Testing

To run the application tests execute this command:

    ./gradlew test


## Running with Docker

Build a Docker image for the demo application by running:

    ./gradlew clean buildDocker

This will create the `sb-memcached-demo` Docker image in your machine's local Docker image registry.
To start a memcached server and the demo application, run:

    docker-compose -f src/main/docker/docker-compose.yml up -d

You should now be able to access REST endpoints e.g.

http://localhost:8080/books (not cached)

http://localhost:8080/books/Kotlin (cached)

To stop and remove the containers, run:

    docker-compose -f src/main/docker/docker-compose.yml down
