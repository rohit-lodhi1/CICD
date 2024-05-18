FROM openjdk:17-jdk-alpine
MAINTAINER rohit
EXPOSE 8671
ADD target/eureka-server.jar  eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]
