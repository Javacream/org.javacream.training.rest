FROM openjdk:8-alpine
ADD ./org.javacream.training.rest.books.server-1.0.jar ./app.jar
EXPOSE 8080
CMD java -jar app.jar --spring.datasource.url=jdbc:h2:file:~/sample;
