#!/bin/sh

echo "The application will start in ${WAIT_TIME}s..." && sleep $WAIT_TIME
for f in /app/*.jar
do
    cp $f /tmp/app.jar
done
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "/tmp/app.jar" "$@"

