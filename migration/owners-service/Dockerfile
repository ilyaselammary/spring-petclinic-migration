# Dockerfile corrigé à utiliser pour TOUS les services
FROM openjdk:17-jdk-alpine

# Créer un répertoire app
WORKDIR /app

# Copier le jar (sera généré par Maven)
COPY target/*.jar app.jar

# Exposer le port (optionnel mais propre)
EXPOSE 8080

# Point d'entrée
ENTRYPOINT ["java", "-jar", "app.jar"]
