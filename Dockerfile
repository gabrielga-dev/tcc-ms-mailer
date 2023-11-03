FROM openjdk:11
EXPOSE 8082
ADD target/my-events-ms-mailer-docker.jar my-events-ms-mailer-docker.jar
ENTRYPOINT ["java", "-jar", "/my-events-ms-mailer-docker.jar"]
