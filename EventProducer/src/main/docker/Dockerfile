FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
VOLUME /app
ADD event-producer-1.0.0-spring-boot.jar application.jar
RUN sh -c 'touch /application.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dfile.path=app/ -Djava.security.egd=file:/dev/./urandom -jar /application.jar" ]