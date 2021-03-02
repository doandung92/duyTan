FROM ubuntu:latest
RUN apt-get update && apt-get install -y openjdk-11-jdk
ARG JAR_FILE=target/*.jar
WORKDIR /usr/local/bin/myApp
ADD . ./
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]