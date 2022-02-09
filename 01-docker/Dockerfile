FROM openjdk:16
ARG JAR_FILE=build/libs/yaml-task-1.0-SNAPSHOT.jar
WORKDIR /usr/local/bin/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]