FROM maven:3.8.5-openjdk-17 AS build
COPY ../spotifybackend-main/spotifybackend-main .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-1.0-SNAPSHOT.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "demo.jar" ]

