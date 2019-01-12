#Concurrency design patterns
 - Signaling
 - Guarded suspension (wait()/notify())
 - Rendezvous
 - Mutex
 - Multiplex
 - Barrier
 - Double-checked locking
 - Read-write lock
 - Thread pool
 - Thread local storage

Java API for Concurrent and Parallel computing
  - Core
     - Object
     - Thread
     - Runnable
     - Callable
     - Future
  - Locks
     - ReentrantLock
     - ReadWriteLock
  - Thread management
    - Executor
    - ExecutorService
        - ThreadPoolExecutor
                - Worker class
                - Set of Workers
        - ForkJoinPool
    - ScheduledExecutorService
        - ScheduledThreadPoolExecutor
  - Synchronization utilities
    - Semaphore
    - CountDownLatch
    - CyclicBarrier
  - ForkJoinTask
    - RecursiveAction
    - RecursiveTask
 