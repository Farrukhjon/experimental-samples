Why batch processing
What is batch processing
Batch processing
  Books and learning resources:
    Spring Batch - Reference Documentation
    Pro Spring Batch (M. Minella).
    Spring Batch Essentials (P. Raja)
    Spring Batch in Action (O. Bazoud)
  Questions and Background
    Data processing/computing models
      Interactive processing/computing (by Time-Sharing)
      Transaction processing
      Real-Time (Reactive) processing
      Near real-time processing
      Batch processing/computing (Non-Real, Non-Interactive)
      Overview
  What is batch processing?
     is processing (reading/manipulating/writing)
      of a finite amount of data
      without
        interaction/interruption
   Finite vs Infinite
   Terminologies
     Job Processing Workload
   Use Cases:
      Executing Batch of Jobs at Scheduled time.
        Reporting
        Data Science
        Big Data
        Non-Interactive Processing
        Processing Repeated Jobs
  Batch processing application vs Real-time application
    Real-Time application
      Kicking-off application/processing
        by incoming External Stimulus:
          Requests to Web Application
          Messages in the Messaging-based Application
  Batch processing
      without any External Stimulus
    Batch Scheduling and Execution Environments
      cron, at, quiz, autosys
    Use cases
      Read-Process-Write pattern
      ELT patter. ETL (Extract Transform and Load) data
        Extract data from external data Source
        Transform extracted data to match a specific form
        Load transformed data to Destination 
      A Batch Application characteristics
        Automation/ no human interaction
        Large amount/volume of data
        Long computation/Large Complex Calculation/No Real-Time
        Data Accumulation Driven But No Even/Notification Driven
        Robustness/ability to handle invalid data
        Reliability - monitoring/logging/notification
        Performance 
    Terminology of the Batch Context (Domain language)
      Job
        Instance
        Parameters
        Execution
      Step
        Execution
      Execution context
      Job Repository
      Job Launcher
      Item
        Reader
        Processor
        Writer
      Batch XML Namespaces
Batch in Java Platform. JSR-352.
  Terminology
    Job
      Job Instance
      Job Parameters
      Job Execution
    Step
      Step Execution
        Serial
        Parallel
      Steps:
        Tasklets
          Chunks
          Chunk Oriented Processing Tasklet
Spring Batch Framework
  is the Batch Framework on the JVM
     based on the JSR-352 specification
  Features:
     Job Flow State Machine
     Transaction Handling
     Declarative I/O
     Error Handling
     Scalability options
     Battle Tested
     Built on Spring
  Job is
    a Flow of Steps/States in which you progress through 
  Job 1 -> n JobInstance 1 -> n JobExecution  
  Job Flow
    Transitions
    Flows
    Slits
    Decisions
    Nested Jobs
    Listeners
    Job Parameters
  Input
    ItemReader
  Output
    ItemWriter
  Processing
  JobRepository
     Jobs
     Steps
        State storage
    Types
      In-Memory: Map
      JDBC
  Error Handling
  Scaling Jobs
  Job Orchestration
  Configuring a Job
    Restartability
    Intercepting Job Exceptions
    Job Inheritance
    Job Parameters Validator
  Running a Job from:
    Command Line
      CommandLineJobRunner
      ExitCodes
      Scheduling
        Cron  
    A Web container
  Spring Batch and Spring Integration
    A Job in essence is a State Machine 
  Starting/Launching Batch Jobs
    From
      Command line
      Java program
      Schedulers
        Cron, Spring Scheduler, Quartz, AutoSys...
      Web applications
Spring Batch Testing Module
   JobLauncherTestUtils
   
Job Conditional Flow
  Transitions
  Flows
  Splits
  Decisions
  Nested Jobs
  Listeners
  Job Parameters
  BatchStatus vs ExitStatus
    BatchStatus
      COMPLETED
      STARTING
      STARTED
      STOPPING
      STOPPED
      FAILED
      ABANDONED
      UNKNOWN
Spring Batch Dependencies
  Spring Core
    Dependency Injection
    SpEL
    Bean Factory
    Transaction Platform
    AOP
  Batch libraries
    spring-batch-core
    spring-batch-infrastructure
    spring-batch-test
Use Cases and Approches
  Input/Process/Output
    Databse
    Flat file
    Multi Flat files
    XML file
    Multi XML files
  Tasklet vs Chunk-oriented
  Multi-threaded Steps
  Partitioning
    Loca
    Remote
  Decisioning
  Listeners
Testing Spring Batch Application
  Unit testing
  Integration testing
      
      