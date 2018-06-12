FROM openjdk:8-jdk-alpine
ENV PORT 8080
COPY rldd-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=$PORT","-jar","/app.jar"]