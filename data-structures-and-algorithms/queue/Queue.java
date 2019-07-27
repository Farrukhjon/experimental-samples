/**
 *
 * Queue Abstract Data Type (Queue ADT)
 *
 * */

public interface Queue<T> {

    void enqueue(T item);
    
    T dequeue();

    int size();

    void printQueue();

}


