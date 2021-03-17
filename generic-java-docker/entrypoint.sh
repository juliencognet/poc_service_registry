#!/bin/sh

echo "The application will start in 10s..." && sleep 10
for f in /app/*.jar
do
    cp $f /tmp/app.jar
done
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "/tmp/app.jar" "$@"

