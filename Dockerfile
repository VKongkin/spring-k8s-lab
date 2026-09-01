FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build --chown=1000:1000 /src/target/*.jar app.jar
USER 1000
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]