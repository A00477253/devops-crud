FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 9191
EXPOSE 9191
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar