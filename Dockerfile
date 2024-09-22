FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY target/backend_asistencias-0.0.1-SNAPSHOT.jar /opt/app/
CMD ["java", "-jar", "/opt/app/backend_asistencias-0.0.1-SNAPSHOT.jar"]

