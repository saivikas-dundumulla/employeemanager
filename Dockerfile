FROM amazoncorretto:17-alpine
COPY build/libs/employeemanagersvc-1.0.0-SNAPSHOT.jar employeemanagersvc.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employeemanagersvc.jar"]