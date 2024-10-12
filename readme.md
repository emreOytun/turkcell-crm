# Turkcell CRM Project
- A CRM project developed in the Turkcell Spring Bootcamp by the Pair3 group.

# Tech Stack
- Java 17
- Spring 3.X.X
- Microservices
- Spring Cloud Eureka
- Spring Cloud API Gateway
- Circuit Breaker & Retry Mechanisms
- Docker
- Kubernetes (GKE - Google Kubernetes Engine)
- Jenkins
- SonarQube
- JWT Auth
- JUnit, Mockito
- Lombok
- Mapstruct
- Multiple Language Support with Resource Bundle
- Feign Client through Eureka and Kubernetes DNS resolution
- Multiple application.resources for Different Environments

# Setup
1) Install docker on your machine
2) Download [turkcell-crm-core](https://github.com/emreOytun/turkcell-crm-core.git) and build it.
3) Build the applications.
4) Change the dockerfiles such that they don't clean build in the image but only get copy of the already built jar.
5) In the terminal write the command "docker compose up -d".

NOTE: 
- In the [turkcell-crm-configs](https://github.com/emreOytun/turkcell-crm-configs), you can find the config files.
- Dev configs are for local, prod configs are for GKE.

# Screenshots

# Jenkins:
![Jenkins1](https://github.com/emreOytun/turkcell-crm/blob/master/screenshots/jenkins1.png)
![Jenkins2](https://github.com/emreOytun/turkcell-crm/blob/master/screenshots/jenkins2.png) 

# Kubernetes
![Kubernetes1](https://github.com/emreOytun/turkcell-crm/blob/master/screenshots/kubernetes1.png)
![Kubernetes2](https://github.com/emreOytun/turkcell-crm/blob/master/screenshots/kubernetes2.png)

# SonarQube
![SonarQube1](https://github.com/emreOytun/turkcell-crm/blob/master/screenshots/sonarqube1.png)

# Postman
![Postman1](https://github.com/emreOytun/turkcell-crm/blob/master/screenshots/postman1.png)
