FROM node:16 AS frontend-build
WORKDIR /app
COPY currency-front-end/package*.json ./
RUN npm install
COPY currency-front-end/ .
RUN npm run build --prod

FROM openjdk:17 AS backend-build
WORKDIR /app
COPY . .
COPY --from=frontend-build /app/dist/currency-front-end /src/main/resources/static
RUN ./gradlew build -x test

FROM openjdk:17
WORKDIR /app
COPY --from=backend-build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
