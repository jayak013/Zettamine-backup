FROM openjdk:17-jdk-slim

MAINTAINER zettamine.com

COPY target/sb-docker.jar sb-h2-docker.jar

ENTRYPOINT ["java","-jar","sb-h2-docker.jar"]