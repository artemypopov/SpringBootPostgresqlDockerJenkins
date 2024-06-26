# creates a layer from the openjdk:17-alpine Docker image.
FROM openjdk:17-alpine

# cd /app
WORKDIR /app

# Refer to Maven build -> finalName
ARG JAR_FILE=target/SpringBootPostgresqlDockerJenkins-*.jar

# cp target/SpringBootPostgresqlDockerJenkins-0.0.1-SNAPSHOT.jar /app/SpringBootPostgresqlDockerJenkins.jar
COPY ${JAR_FILE} SpringBootPostgresqlDockerJenkins.jar

# java -jar /app/spring-boot-docker.jar
CMD ["java", "-jar", "-Xmx1024M", "/app/SpringBootPostgresqlDockerJenkins.jar"]

# Make port 8090 available to the world outside this container
EXPOSE 8090