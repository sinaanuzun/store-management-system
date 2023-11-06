FROM openjdk:11-jdk
EXPOSE 8083
WORKDIR /app
COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
