# Invoke GCP pubsub services from APP deployed in CCP 

This is a working sample for building Java/J2EE   for building  spring Boot app  by consuming Google CLOUD Pub Sub Services through Open Service Broker API.

# How to Build this application?
```bash
* Local Build  :  mvn clean package 
* Docker Build :  docker build -t  hybrid-gcp-ccp-app
```
# How to Deploy this application
```bash
* Standlone: java -jar target/hybrid-gcp-ccp-app-0.1.0.jar
* Kubernets: kubectl apply -f hybrid-app-using-gcp-broker.yaml
```

# How to test this application
```bash
* Standlone: java -jar target/hybrid-gcp-ccp-app-0.1.0.jar
* Docker: docker run  -p 8080:80 -name hybrid-gcp-ccp-app    jbeginsamuel/demo-app:ver10
* Kubernets: kubectl apply -f hybrid-app-using-gcp-broker.yaml
```

# GCP PubSub app pre-requisite/Dependency for Kubernets deployment

* on-premises environment, GCP Service Broker shoud be registered.
* on-premises, Service Instances and Service Binding should be done and it should be in ready state.
* Appliction Docker container should be pushed to Docker Hub or Google Container Registry.



# License
 [MIT](/LICENSE)
