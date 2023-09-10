./mvnw clean install

cp target/task-0.0.1-SNAPSHOT.jar src/main/docker/application.jar

docker build src/main/docker/ -t currency-app
