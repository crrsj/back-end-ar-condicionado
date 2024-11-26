
# Use uma imagem base com OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR da aplicação para o diretório de trabalho
COPY target/Ar-condicionado-1.0.0-SNAPSHOT.jar app.jar

# Exponha a porta usada pela aplicação (opcional, apenas para documentação)
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
