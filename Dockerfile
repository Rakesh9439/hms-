FROM openjdk:17

COPY target/Hospital-Management-System.jar /usr/app/

WORKDIR /usr/app/

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "Hospital-Management-System.jar"]
