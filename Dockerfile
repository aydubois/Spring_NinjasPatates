FROM openjdk:14-jdk-alpine
ARG TARGET
COPY $TARGET app.jar
ENTRYPOINT ["java","-jar","app.jar"]