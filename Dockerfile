FROM alpine
# FROM busybox:1-musl
# FROM ofayau/ejre
# FROM openjdk:8-jdk-alpine 

MAINTAINER José Luis Quispe Luyo

RUN apk update \
	&& apk add openjdk8-jre \
	&& java -version
COPY target/micrometer-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar", "app.jar"]
