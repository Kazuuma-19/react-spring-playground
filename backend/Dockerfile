FROM openjdk:21

WORKDIR /app

COPY build/libs/backend-0.0.1-SNAPSHOT.jar /app/react-spring-playground.jar

ENTRYPOINT ["java", "-jar", "/app/react-spring-playground.jar"]

EXPOSE 8080