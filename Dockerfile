FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=0 \
    JAVA_OPTS=""

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]