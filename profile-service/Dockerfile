FROM maven:3.6.3-jdk-11 AS build

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN mvn clean install -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/profile-service-0.0.1-SNAPSHOT.jar"]
