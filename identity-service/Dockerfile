FROM maven:3.6.3-jdk-11 AS build

RUN mkdir -p /tmp/bookteria

COPY identity-service /tmp/bookteria/identity-service

WORKDIR /tmp/bookteria/identity-service

RUN mvn clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/identity-service-0.0.1-SNAPSHOT.jar"]