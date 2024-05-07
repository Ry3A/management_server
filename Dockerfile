FROM openjdk:19-alpine

WORKDIR /app 

COPY . .

RUN ./gradlew build

EXPOSE 9090

CMD ["java", "-jar", "/app/build/libs/management-0.0.1.jar"]