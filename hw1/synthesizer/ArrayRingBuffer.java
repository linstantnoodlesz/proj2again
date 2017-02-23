// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;
//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend synthesizer.AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {

    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] queue;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) throws RuntimeException {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (last == capacity) {
            last = 0;
        }
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        queue[last] = x;
        fillCount++;
        last++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() throws RuntimeException {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (first == capacity) {
            first = 0;
        }
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T item = queue[first];
        queue[first] = null;
        fillCount--;
        first++;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return queue[last];
    }
    // TODO: When you get to part 5, implement the needed code to support iteration.
    public class Iterable implements Iterator<T> {
        private int current;
        public Iterable() {
            current = 0;
        }
        public boolean hasNext() {
            return current < capacity;
        }
        public T next() {
            T currentitem = queue[current];
            current++;
            return currentitem;
        }
    }

    public Iterator<T> iterator() {
        return new Iterable();
    }
}
