package synthesizer;

import java.util.Iterator;

/**
 * Created by gilbertlin on 2/21/17.
 */
public interface BoundedQueue<T> extends Iterable<T>{
    int capacity(); // return size of the buffer
    int fillCount();  // return number of items currently in the buffer

    void enqueue(T x) throws Exception;  // add item x to the end
    T dequeue() throws Exception;       // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    Iterator<T> iterator();

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull()  {
        return fillCount() == capacity();
    }

}

