FROM openjdk:17-jdk-alpine
COPY build/test-0.0.1-SNAPSHOT.jar test-0.0.1.jar
EXPOSE 8787
CMD ["java","-jar","/test-0.0.1.jar"]