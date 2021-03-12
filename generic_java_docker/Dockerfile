FROM adoptopenjdk/openjdk11

ENV http_proxy $HTTP_PROXY
ENV https_proxy $HTTP_PROXY

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

# Add a javaserviceuser user to run our application so that it doesn't need to run as root
#RUN adduser -D -s /bin/sh javaserviceuser
#WORKDIR /home/javaserviceuser

ADD entrypoint.sh entrypoint.sh
#RUN chmod 755 entrypoint.sh && chown javaserviceuser:javaserviceuser entrypoint.sh
RUN mkdir /app
#USER javaserviceuser

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080
