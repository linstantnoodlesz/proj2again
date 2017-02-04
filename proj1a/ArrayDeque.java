/**
 * Created by gilbertlin on 2/3/17.
 */
public class ArrayDeque <Var> {
    /**
     * public void addFirst(Item): Adds an item to the front of the Deque.
     * DONE public void addLast(Item): Adds an item to the back of the Deque.
     * DONE public boolean isEmpty(): Returns true if deque is empty, false otherwise.
     * DONE public int size(): Returns the number of items in the Deque.
     * public void printDeque(): Prints the items in the Deque from first to last, separated by a space.
     * public Item removeFirst(): Removes and returns the item at the front of the Deque. If no such item exists, returns null.
     * DONE public Item removeLast(): Removes and returns the item at the back of the Deque. If no such item exists, returns null.
     * DONE public Item get(int index): Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.
     */
    private Var[] items;
    private int size;

    /** Returns the number of items in the Deque. */
    public int size() {
        return size;
    }
    /** Creates empty ArrayDeque. */
    public ArrayDeque() {
        items = (Var[]) new Object[8];
        size = 0;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void addFirst(Var x ) {

    }

    /** Adds an item to the back of the Deque. */
    public void addLast(Var x) {
        items[size] = x;
        size += 1;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. */
    public Var get(int index) {
        if (index > size()) {
            return null;
        }
        return items[index];

    }
    /** Removes and returns the item at the back of the Deque. */
    public Var removeLast() {
        Var removeditem = items[size-1];
        size -= 1;
        return removeditem;
    }

}

