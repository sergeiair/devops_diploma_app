FROM openjdk:17-jdk-slim

WORKDIR /app

COPY app.java .

RUN javac app.java

EXPOSE 8080

CMD ["java", "app"]
