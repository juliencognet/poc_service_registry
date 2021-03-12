#!/bin/sh

echo "The application will start in 20s..." && sleep 20
for f in /app/*.jar
do
    cp $f /tmp/app.jar
done
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "/tmp/app.jar" "$@"

