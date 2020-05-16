FROM openjdk:8-jdk-alpine

WORKDIR /e-commerce-back
COPY ./target/back-0.1.jar ./target/

ENTRYPOINT ["java", "-jar", "/e-commerce-back/target/back-0.1.jar"]