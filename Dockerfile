FROM adoptopenjdk/openjdk15:alpine

#COPY . .

# RUN ./gradlew build

# RUN cp build/libs/*.jar app.jar

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]