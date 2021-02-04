# quarkus-hpa project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and deploying the application

The application can be packaged using:
```shell script
./mvnw package -DskipTests
```

## Add a RR annotation to Route

```shell script
oc annotate route quarkus-hpa haproxy.router.openshift.io/balance=roundrobin
```

## Create a HPA

You can use `oc` CLI to create the following CR or Developer Console:

```
kind: HorizontalPodAutoscaler
apiVersion: autoscaling/v2beta2
metadata:
  name: example
  namespace: hpa-quarkus-demo
spec:
  scaleTargetRef:
    apiVersion: apps.openshift.io/v1
    kind: DeploymentConfig
    name: quarkus-hpa
  minReplicas: 1
  maxReplicas: 10
  metrics:
    - type: Resource
      resource:
        name: memory
        target:
          type: Utilization
          averageUtilization: 60
```

## Fill data for increasing Memory utilization of Quarkus apps

```shell script
sh quarkus-hpa/script/fill-data.sh 100
```
