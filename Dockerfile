FROM openjdk:11
ADD target/Credit.jar credit.jar
EXPOSE 8074
ENTRYPOINT ["java", "-jar", "credit.jar"]
