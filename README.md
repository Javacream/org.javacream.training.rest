# org.javacream.training.rest.people.server

- Download executable artefact
- start executable java -jar org.javacream.training.rest.people.server-1.0.jar
  - Java 10: java --add-modules java.xml.bind -jar org.javacream.training.rest.people.server-1.0.jar
- web server will startup using port 8080 and embedded database
  - change port using --server.port=<port>
- browse to localhost:8080/people, you will see some data 
- REST-API supports CRUD on endpoint /people, supported mediatype is JSON
- Swagger UI available at http://localhost:8080/swagger-ui.html
- Docker Image available, use docker push javacream/restserver:people