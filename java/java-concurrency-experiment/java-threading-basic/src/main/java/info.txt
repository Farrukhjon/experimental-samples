Lock(a.k.a) monitor

The synchronizers provided in the java.util.concurrent library and their uses are listed here:
 - Semaphore controls access to one or more shared resources.
 - Phaser is used to support a synchronization barrier.
 - CountDownLatch allows threads to wait for a countdown to complete.
 - Exchanger supports exchanging data between two threads.
 - CyclicBarrier enables threads to wait at a predefined execution point.
 
 Atomic - state when in same time only one thread can read or write a resource.
 Synchronization (a.k.a called locking and unlocking)
 Mutex - mutable execution
 Modifier synchronized not allowed to constructor. Because the JVM ensures that only one thread can invoke a
 constructor call (for a specific constructor) at a given point in time
 
 The wait/notify mechanism
  - communication between threads;