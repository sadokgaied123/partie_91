FROM openjdk:11
EXPOSE 8081
ADD target/app.jar app.jar
# Démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]