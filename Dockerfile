# Step 1: Build Angular Frontend
FROM node:16 AS frontend-build
WORKDIR /frontend
COPY currency-front-end/package*.json ./
RUN npm install
COPY currency-front-end/ .
RUN npm run build --prod

# Step 2: Build Java Backend
FROM openjdk:17 AS backend-build
WORKDIR /app
COPY . .
COPY --from=frontend-build /frontend/dist/currency-front-end /src/main/resources/static
RUN ./gradlew build -x test

# Step 3: Run the Application
FROM openjdk:17
WORKDIR /app
COPY --from=backend-build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
