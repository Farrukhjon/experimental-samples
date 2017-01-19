In this project I've implemented some practices for Data Access using Spring ORM for JPA and Hibernate.
Oracle is used as underlying DBMS. 
Third versions are chosen for both Spring and Hibernate.

The "HR" sample data is used for the persistence side.
Main Dependencies
  group: org.hibernate
    artifact: hibernate-core.jar
    artifact: hibernate-entitymanager.jar
    artifact: hibernate-ehcache.jar
    artifact: hibernate-c3p0.jar
  group: org.hibernate.javax.persistence
    artifact: hibernate-jpa-2.0-api.jar
  
Hibernate Core:
  SessionFactory
  Cache
    Session Cache
    Second Level Cache
    Query Cache
Hibernate EntityManager (JPA 2.0 specification implementation) 
  hibernate-entitymanager.jar 
  EntityManagerFactory
  EntityManager
  Persistence context
  Persistence unit
  JTA entity manager

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


Object States and State Transitions
  Transient
    created by 'new' keyword
    not associated with a Session object
    no persistent 
    no identifier
    can be destroyed/managed by GC
  Persistent
    is in the DB
    have an identifier
    managed by Session
  Detached
    has been persistent
    a session has been closed

Mapping approaches
  XML-based object/table mapping
  Annotation-based object/table mapping
    
Querying approaches:
  Static
     HQL
       String queries
         are Case Insensitive!
       Classes and Interfaces
         org.hibernate.Query
       Creation: Session.createQuery()
     JPQL
       Classes and Interfaces
         javax.persistence.Query
         javax.persistence.TypedQuery
       Creation: EntityManager.createQuery()
     Native SQL
       Creation: Session.createSQLQuery() // by Session
       Creation: EntityManager.createNativeQuery() //by EntityManger
  Dynamic
     Criteria
  Filters (Collection filtering)
       Creation: Session.createFilter()
  Query
  NamedQuery Named Queries (Queries externalization, Class Level)
    Annotations
      @NamedQuery
      @NamedQueries
    Scope
     Global, per SessionFactory/EntityManager
  TypedQuery
Querying
  Parameters
    Bind Parameters
     Named parameters
     Positional (number) parameters
Batch Processing
  Insert
  Update
  StatelessSession
  DML-style operations (Bulk operators, or Bulk Update/Delete)
HQL. Writing queries
  CRUD operators
  Clauses
    from
      "from <class name>"
    select
      "select <atributes..,> from <class name>"        
      "select new list(<atributes..,>) from <class name>" result set returned as List        
      "select new map(<atributes..,>) from <class name>"  result set returned as Map      
      "select new <some_type>(<atributes..,>) from <class name>" result set returned as List of <some_type>        
    where
    order by
    group by
  association and joins
  identifier
  functions for aggregating
  Pagination result
    Query.setFirstResult(int startPosition)
    Query.setMaxResults(int maxResult)
  Polymorphism in querying
  Expressions
  Subqueries
  Bulk operators 
Criteria Queries
  Typed Criteria queries  
  
Spring Transaction Support for Hibernate
Core classes, interfaces and Annotations
  TransactionFactory
    SpringTransactionFactory implementation 
  HibernateTransactionManager
  @Transactional
    Attributes (Properties) and their Values
      propagation
        REQUIRED
        SUPPORTS
        MANDATORY
        REQUIRES_NEW
        NOT_SUPPORTED
        NEVER
        NESTED
      isolation
        DEFAULT
        READ_UNCOMMITTED
        READ_COMMITTED
        REPEATABLE_READ
        SERIALIZABLE
      timeout
        
      
        
        
 