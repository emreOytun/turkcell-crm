FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
# Copy the external JAR file
COPY core-1.1.6.jar /app/
# Install the external JAR into your local Maven repository
RUN mvn install:install-file -Dfile=core-1.1.6.jar -DgroupId=com.turkcell.pair3.core -DartifactId=core -Dversion=1.1.6 -Dpackaging=jar -DgeneratePom=true
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/customerservice-0.0.1-SNAPSHOT.jar /app/customerservice.jar
CMD java -jar /app/customerservice.jar