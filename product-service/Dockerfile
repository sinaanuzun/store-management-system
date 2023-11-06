FROM openjdk:11-jdk
EXPOSE 8082
WORKDIR /app
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
