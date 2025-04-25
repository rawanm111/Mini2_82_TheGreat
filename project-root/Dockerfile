# ---- Build stage ----
FROM openjdk:23-jdk-slim AS builder

# install maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

# copy only what we need for dependency resolution first
COPY pom.xml .

# download dependencies
RUN mvn dependency:go-offline -B

# now copy the rest of the source
COPY src ./src

# build the jar (skip tests for speed; you can remove -DskipTests if you like)
RUN mvn clean package -DskipTests

# ---- Runtime stage ----
FROM openjdk:23-jdk-slim

WORKDIR /app

# copy the fat jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# tell Docker which port your Spring Boot app listens on
EXPOSE 8080

# run it
ENTRYPOINT ["java", "-jar", "app.jar"]
