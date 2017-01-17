In this project I've implemented some practices for Data Access using Spring ORM for JPA and Hibernate.
Oracle is used as underlying DBMS. 
Third versions are chosen for both Spring and Hibernate.

The "HR" sample data is used for the persistence side.

Hibernate3:
  - SessionFactory
  - Cache
    - Session Cache
    - Second Level Cache
    - Query Cache
JPA
  - EntityManager


Common/General interfaces and classes
 - org.farrukh.experiments.spring.orm // Root package
 - org.farrukh.experiments.spring.orm.model
 - org.farrukh.experiments.spring.orm.dao
 - org.farrukh.experiments.spring.orm.service
 
Hibernate3 specific interfaces and classes
 - org.farrukh.experiments.spring.orm.hibernate3.config
 - org.farrukh.experiments.spring.orm.hibernate3.dao
 
JPA specific interfaces and classes
 - org.farrukh.experiments.spring.orm.jpa.config
 - org.farrukh.experiments.spring.orm.jpa.dao
 