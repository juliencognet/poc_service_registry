FROM adoptopenjdk/openjdk11

ENV http_proxy $HTTP_PROXY
ENV https_proxy $HTTP_PROXY

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

# Download consul
#RUN curl -k https://releases.hashicorp.com/consul/1.9.4/consul_1.9.4_linux_amd64.zip -o /tmp/consul.zip
ADD consul_1.9.4_linux_amd64.zip /tmp
RUN apt-get update
RUN apt-get install unzip
RUN unzip /tmp/consul_1.9.4_linux_amd64.zip -d /tmp/consul
RUN mv /tmp/consul/consul /bin

RUN mkdir -p /consul/data && \
    mkdir -p /consul/config

ADD entrypoint.sh entrypoint.sh
RUN mkdir /app
ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080
