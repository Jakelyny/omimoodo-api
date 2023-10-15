
FROM maven:3.8-openjdk-17 as build

COPY . .

RUN mvn clean package

FROM ibm-semeru-runtimes:open-17-jre-centos7

# Copy the jar to the production image from the builder stage.
COPY --from=build /target/omimoodo-api.jar omimoodo-api.jar

# ENV PORT=8080
EXPOSE 8080

# Run the web service on container startup.
ENTRYPOINT ["java","-jar","omimoodo-api.jar"]