FROM adoptopenjdk:17-jdk-hotspot

# Instala o Maven
RUN apt-get update
RUN apt-get install -y maven

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo pom.xml e o arquivo src para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Execute o comando 'mvn package' para construir o aplicativo
RUN mvn package

# Expõe a porta que a aplicação Spring irá escutar
EXPOSE 8080

# Comando para iniciar a aplicação Spring
CMD ["java", "-jar", "target/omimoodo-api.jar"]