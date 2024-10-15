# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/tu-aplicacion.jar app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
