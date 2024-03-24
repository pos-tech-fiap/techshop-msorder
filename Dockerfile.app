#  docker run -p 27017:27017 --name mongodb-reactive-container -d mongo
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

RUN ./gradlew --no-daemon

COPY . .

RUN ./gradlew build

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/build/libs/ms_order-0.0.1-SNAPSHOT.jar"]