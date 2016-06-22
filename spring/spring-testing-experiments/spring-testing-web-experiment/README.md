Spring Framework Testing and Spring Boot
----

1. Spring Boot dependencies for Spring Testing Modules:````
```
\--- org.springframework.boot:spring-boot-starter-test: -> 1.3.5.RELEASE
     +--- junit:junit:4.12
     |    \--- org.hamcrest:hamcrest-core:1.3
     +--- org.mockito:mockito-core:1.10.19
     |    +--- org.hamcrest:hamcrest-core:1.1 -> 1.3
     |    \--- org.objenesis:objenesis:2.1
     +--- org.hamcrest:hamcrest-core:1.3
     +--- org.hamcrest:hamcrest-library:1.3
     |    \--- org.hamcrest:hamcrest-core:1.3
     +--- org.springframework:spring-core:4.2.6.RELEASE
     \--- org.springframework:spring-test:4.2.6.RELEASE
          \--- org.springframework:spring-core:4.2.6.RELEASE
```
