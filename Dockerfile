FROM maven:3.6.3 AS maven
LABEL MAINTAINER="pedroafsouza@gmail.com"

WORKDIR /src/app
COPY . /src/app
# Compile and package the application to an executable JAR
RUN mvn package

FROM openjdk:8-jdk-alpine
ARG calendar_app.jar
WORKDIR /opt/app

# Copy the calendar_app.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","/opt/app/calendar-app.jar"]