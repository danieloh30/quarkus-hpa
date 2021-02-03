#!/bin/bash

INDEX=$1

if [ -z "$INDEX" -o "$INDEX" = "" ]
  then
    echo "Usage: Input your INDEX like fill-data.sh 100"
    exit;
fi

echo INDEX is $INDEX

for ((i = 1; i <= $INDEX; i++ ));
do
    curl http://quarkus-hpa-hpa-quarkus-demo.apps.cluster-90f1.90f1.sandbox180.opentlc.com/hello/fill/$i
    sleep 2
done