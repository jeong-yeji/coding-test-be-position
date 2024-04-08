FROM gradle:jdk17 as builder
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN gradle build --no-daemon -x test

FROM arm64v8/openjdk:17-ea-16-jdk
EXPOSE 8080
WORKDIR /usr/src/app
COPY --from=builder /usr/src/app/build/libs/*.jar ./
CMD ["java","-jar","./api-0.0.1-SNAPSHOT.jar"]
