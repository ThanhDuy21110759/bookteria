FROM maven:3.6.3-jdk-11 AS build

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN cd /usr/src/app/identity-service

RUN mvn clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/identity-service-0.0.1-SNAPSHOT.jar"]
