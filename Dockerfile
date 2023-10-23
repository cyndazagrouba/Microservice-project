# Utilisez une image Java 8 en tant qu'image parent
FROM openjdk:8-jre-slim

# Copiez le fichier JAR de votre application Eureka Server dans le conteneur
COPY target/EurekaServerProject-0.0.1-SNAPSHOT.jar /app/eureka-server.jar

# Définissez le répertoire de travail
WORKDIR /app

# Exposez le port sur lequel le serveur Eureka écoute (par exemple, 8761)
EXPOSE 8761

# Commande pour exécuter l'application lorsque le conteneur démarre
CMD ["java", "-jar", "eureka-server.jar"]
