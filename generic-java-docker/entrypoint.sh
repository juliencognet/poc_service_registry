#!/bin/sh

echo "The application will start in 10s..." && sleep 10

echo ">> Starting consul agent"
consul agent -retry-join consul-server-bootstrap -client 0.0.0.0 -data-dir=/consul/data -config-dir=/consul/config &

sleep 5

echo ">> Starting Java application"
for f in /app/*.jar
do
    cp $f /tmp/app.jar
done
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "/tmp/app.jar" "$@" &

tail -f /dev/null

