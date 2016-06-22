### Spring MVC Content Negotiation examples

A simple example shows how to create REST micro-service using spring MVC and Groovy and Spock
#### The example project created using:
 - Gardle
 - Spring boot
 - Groovy programming language
 - Spock framework for testing

#### How to build and run:
`
 - gradlew.bat (from unix system: ./gradlew)
 - java -jar build/libs/spring-mvc-content-negotiation-examples-0.0.1-SNAPSHOT.jar
`
 
### API Documentation
#### Supported HTTP methods

|  HTTP Method  |       Resource example             |   Description        |
|---------------|------------------------------------|----------------------|
|   GET         |   http://localhost:8080/products/1 | Gets a product by id |
|   POST        |   http://localhost:8080/products   |  Insert a new product|

#### Supported MIME types

 - application/json
 - application/xml
 
#### Get request example for JSON payload:
 `
 HTTP GET: /products/1
 Server: http://localhost
 Port: 8080
 Accept: appliaction/json
 Content-Type: appliaction/json
 `
 
#### Get request example for XML payload:
`
HTTP GET: /products/1
Server: http://localhost
Port: 8080
Accept: appliaction/xml
Content-Type: appliaction/xml
`
 
#### POST request example for JSON payload:
`
HTTP POST: /products
Server: http://localhost
Port: 8080
Accept: appliaction/json
Content-Type: appliaction/json
`
 
#### POST request example for XML payload:
`
HTTP POST: /products
Server: http://localhost
Port: 8080
Accept: appliaction/xml
Content-Type: appliaction/xml
`