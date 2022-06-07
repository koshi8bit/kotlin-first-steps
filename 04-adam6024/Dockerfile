FROM openjdk:17
ARG JAR_FILE=build/libs/hello-world-0.0.1-SNAPSHOT.jar
WORKDIR /spring-boot-hello-world
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 9090