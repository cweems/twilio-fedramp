# Twilio FedRAMP

This repository provides a Twilio Java client that can redirect requests over a FedRAMP compliant proxy server. It is currently a work in progress.

## Usage
Set up environment variables by copying .env.example to .env:

```
cp .env.example .env
```
Edit the .env file to include your Twilio Account SID, Auth Token, Proxy Host URL, and Port.


Build the package using Maven:
```shell
mvn package
```

Execute the package by running the `twilio-fedramp` JAR:
```shell
java -jar target/twilio-fedramp-0.0.1.jar
```

