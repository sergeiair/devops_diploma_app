FROM openjdk:17-jdk-slim

WORKDIR /app

COPY HelloWorldServer.java .

RUN javac HelloWorldServer.java

EXPOSE 8080

CMD ["java", "HelloWorldServer"]
