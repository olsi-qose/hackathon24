# the base image
FROM gradle:jdk21
WORKDIR /shopify-service
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar /shopify-service/shopify-service.jar
EXPOSE 8081
  
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/shopify-service/shopify-service.jar"]