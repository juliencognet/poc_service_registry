FROM adoptopenjdk/openjdk11

ADD gateway-service.yml /tmp/gateway-service.yml
ADD entrypoint.sh entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
