# Rest full API for money transfers

## Technical details
### Design and Implementation
 - Programming language: Java
 - Database: in-memory, Map
 - Controller: RestEasy


### How to build
 - Install JDK8 or higher version
 - Install maven
  mvn clean install

### How to run
    java -jar target/money-transfers-rest-api-jar-with-dependencies.jar
    
 
### How to use
     - curl -v -X POST \
            -H 'Accpet: application/xml' \
            -H 'Content-type: application/xml' \
            -d '<><>' \
            http://localhost:8181/money/accounts/create 
     - curl -X GET -H http://localhost:8181/money/accounts/1
     - curl -X PUT -H "Content-Type: application/xml" http://localhost:8181/money/accounts/transfer -d 
