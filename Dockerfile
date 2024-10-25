FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY build/libs/*.jar app.jar
ENV DEVOPS=maksim
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]