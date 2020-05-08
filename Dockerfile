FROM openjdk:8
COPY ./target/myCalc-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "myCalc-1.0-SNAPSHOT-jar-with-dependencies.jar"]
