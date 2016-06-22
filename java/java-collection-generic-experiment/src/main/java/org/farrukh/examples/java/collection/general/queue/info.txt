Queue: 
 Direct implementation of Queue (nonblocking Queues):
 - PriorityQueue;
 - ConcurrentLinkedQueue;
 Feature of Queue:
 - insertion is allowed only at the back of the sequence;
 - removal is allowed only at the front of the sequence
 - FIFO manipulating mechanism with elements;

PriorityQueue features:
 - based on priotity heap (balanced binary heap);
 - support natural ordering insertion;
 - a Comparator can be provided in the constructor when instantiating a PriorityQueue. Then the order of the items in the Queue will be decided based on the Comparator provided.
 - by dfault natural order (Comparable) of the Collection will be used to order the elements;
 - null is not allowed in this Collection;
 - head of the Queue is the least item in the order;
 - ordering ties between the PriorityQueue elements are decided arbitrarily;
 - not synchronized. PriorityBlockingQueue is the thread-safe counterpart of PriorityQueue;
 - unbounded and it grows dynamically based on the number of elements in the Queue. It has internal capacity at any given time and it is increased as the elements are added. The policy for this internal capacity and increment is not specified or standardized;
 - The iterator() of this does not guarantee for traversal of the Queue elements in any particular order;
 - performance wise; remove() and contains() methods take linear time. peek(), element() and size() takes fixed time. offer(), poll() and remove() takes O(log n) time;
 - offer() and add() are methods of the Queue interface and implemented by the PriorityQueue;
 - These are used of element insertion in the queue. They behave the same with respect to PriorityQueue and no difference between them.
 
BlockingQueue (extends form Queue)
  Direct implementation of BlockingQueue:
   - ArrayBlockingQueue;
   - LinkedBlockingQueue;
   - PriorityBlockingQueue;
   - DelayQueue;
   - SynchronousQueue.
 When to use:
  - primarily to be used in producer-consumer queues issue;
Deque:
 Direct implementation of Deque:
 - ArrayDeque;
 - LinkedList;
 Feature of Deque: 
 - is a double-ended queue;
 - used as a queue, then, a Deque is always a FIFO structure;
 - if elements are removed from the same end (either head or tail) at which they were added, a Deque acts as a stack or LIFO structure;