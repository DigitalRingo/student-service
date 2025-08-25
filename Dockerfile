FROM bellsoft/liberica-openjdk-alpine:21
COPY ./build/libs/service-0.0.1-SNAPSHOT.jar /opt/service.jar
EXPOSE 8080
CMD java -jar /opt/service.jar