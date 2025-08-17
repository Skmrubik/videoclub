FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
EXPOSE 8080
COPY /target/videoclub-0.0.1-SNAPSHOT.jar videoclub-0.0.1.jar
ENTRYPOINT ["java","-jar","/videoclub-0.0.1.jar"]