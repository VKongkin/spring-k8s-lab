FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
RUN useradd -u 10001 -m spring && chown -R spring:spring /app
USER 10001
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]