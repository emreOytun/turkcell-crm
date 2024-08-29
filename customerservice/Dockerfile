FROM maven:3.8.3-openjdk-17 as build

WORKDIR /app

ARG GITHUB_USERNAME
ARG GITHUB_TOKEN

RUN mkdir -p /root/.m2 && \
    echo "<?xml version='1.0' encoding='UTF-8'?><settings xmlns='http://maven.apache.org/SETTINGS/1.2.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd'><activeProfiles><activeProfile>github</activeProfile></activeProfiles><profiles><profile><id>github</id><repositories><repository><id>central</id><url>https://repo1.maven.org/maven2</url></repository><repository><id>github</id><url>https://maven.pkg.github.com/emreOytun/turkcell-crm-core</url><snapshots><enabled>true</enabled></snapshots></repository></repositories></profile></profiles><servers><server><id>github</id><username>${GITHUB_USERNAME}</username><password>${GITHUB_TOKEN}</password></server></servers></settings>" > /root/.m2/settings.xml

COPY . /app/

############## For common package, but it is moved into core package ############
############## Since common package does not create a maven repository on github, docker cannot download the jar ########
############## We need to copy the jar to dockar image manually ##########

# Copy the 'common' JAR from local machine to the Docker image
# Jar is in the same package as customerservice because dockerfile cannot access other packages
COPY ./docker-libs/common-1.0-SNAPSHOT.jar /app/common-1.0-SNAPSHOT.jar

# Install the 'common' JAR into the local Maven repository inside the Docker image
RUN mvn install:install-file -Dfile=/app/common-1.0-SNAPSHOT.jar -DgroupId=com.turkcell.pair3 -DartifactId=common -Dversion=1.0-SNAPSHOT -Dpackaging=jar

RUN mvn clean package -s /root/.m2/settings.xml -DskipTests

FROM openjdk:17-jdk

COPY --from=build /app/target/customerservice-0.0.1-SNAPSHOT.jar /app/customerservice.jar

CMD ["java", "-jar", "/app/customerservice.jar"]