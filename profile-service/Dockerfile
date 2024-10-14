# Use a newer Maven image with JDK 21
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

RUN mkdir -p /tmp/bookteria/profile-service

WORKDIR /tmp/bookteria/profile-service

COPY src/ ./src/
COPY pom.xml .

# Install dependencies and build the project
RUN mvn clean install -DskipTests

# Use JDK 21 runtime for the application
FROM eclipse-temurin:21

WORKDIR /app
COPY --from=build /tmp/bookteria/profile-service/target/profile-service-0.0.1-SNAPSHOT.jar /app/profile-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

CMD ["java", "-jar", "target/profile-service-0.0.1-SNAPSHOT.jar"]
