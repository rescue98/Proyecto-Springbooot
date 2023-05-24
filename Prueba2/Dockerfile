FROM maven:3.8.5-openjdk-17-slim AS builder

WORKDIR /build

COPY . .

RUN mvn clean package

FROM openjdk:17-slim

EXPOSE 3001

COPY --from=builder /build/target/ /app/

CMD ["java","-jar","/app/Prueba2-0.0.1-SNAPSHOT.jar"]