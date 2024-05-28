# CURRENCY RATE CHECKER API
This API allows to receive last Bitcoin to USD price on White Bit platform. Also, it allows to get it on an email by subscribing preferred email and then send rate onto all subscribed emails, or send rates onto specified emails immidiately.

Since API doesn't have authentication, subscription functionality was disabled in prod version.

Swagger UI documentation is accesible by endpoint /swagger-ui/index.html#/

## Build docker image 

### Pull the image from dockerhub 
Pull image
```bash
docker pull sulimaivan/currency-app:latest_prod
```
or for the full version image
```bash
docker pull sulimaivan/currency-app:latest
```
### Manually build image
```bash
./mvnw clean install -DskipTests

cp target/task-0.0.1-SNAPSHOT.jar src/main/docker/application.jar

docker build src/main/docker/ -t sulimaivan/currency-app
```
## Deploy
Start the container
```bash
docker run -e EMAIL_SENDER_LOGIN='youremailforsending@gmail.com' -e EMAIL_SENDER_PASSWORD='yourpassword' -p 80:8080 sulimaivan/currency-app
```
