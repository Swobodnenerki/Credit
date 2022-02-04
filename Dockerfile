FROM openjdk:11
ADD target/Credit.jar credit.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "credit.jar"]
