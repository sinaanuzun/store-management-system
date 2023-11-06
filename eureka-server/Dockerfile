FROM openjdk:11-jdk
EXPOSE 8761
WORKDIR /app
COPY target/eureka-server-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
