# Base image
FROM openjdk:17

# Set working directory inside container
WORKDIR /usr/app

# Copy the JAR file into the container and rename to app.jar
COPY target/Hospital-Management-System-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which Spring Boot app will run
EXPOSE 8089

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
