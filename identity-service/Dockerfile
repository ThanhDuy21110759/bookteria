# Use a newer Maven image with JDK 21
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

RUN mkdir -p /tmp/bookteria/identity-service

WORKDIR /tmp/bookteria/identity-service

COPY src/ ./src/
COPY pom.xml .

# Install dependencies and build the project
RUN mvn clean install -DskipTests

# Use JDK 21 runtime for the application
FROM eclipse-temurin:21

WORKDIR /app
COPY --from=build /tmp/bookteria/identity-service/target/identity-service-0.0.1-SNAPSHOT.jar /app/identity-service.jar

EXPOSE 8080

CMD ["java", "-jar", "identity-service.jar"]
