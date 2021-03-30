#!/bin/sh

echo "The configuration will be uploaded to Consul in 5s..." && sleep 5
curl -X PUT -H "Content-Type: application/json" --data-binary @./tmp/gateway-service.yml http://consul-server-bootstrap:8500/v1/kv/config/gateway-service/data