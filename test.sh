#!/usr/bin/env bash
ID=$(curl -X PUT -H 'Content-Type: application/octet-stream' -d 'hello' http://localhost:8080/value)

echo ">>$ID"

curl -i http://localhost:8080/value/$ID

