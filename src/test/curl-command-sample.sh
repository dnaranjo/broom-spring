#!/usr/bin/env bash
ABSPATH=$(readlink -f $0)
FOLDER=`dirname $ABSPATH`
curl -i -XPOST http://127.0.0.1:8080/pair -H "Content-Type: application/json" --data-binary "@$FOLDER/json-request-sample.json"