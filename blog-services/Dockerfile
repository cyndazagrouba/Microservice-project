FROM openjdk:8
EXPOSE 8041
ADD target/blog-service.jar blog-service.jar
ENTRYPOINT ["java", "-jar", "blog-service.jar"]