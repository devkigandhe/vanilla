FROM maven:3.8.1-jdk-11
WORKDIR /app
COPY src /app/src
COPY pom.xml /app/pom.xml

CMD ["mvn","test"]
