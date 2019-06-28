FROM java:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} logparser.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/logparser.jar"]
