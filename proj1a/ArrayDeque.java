/**
 * Created by gilbertlin on 2/3/17.
 */
public class ArrayDeque<Var> {
    private Var[] items;

    private int size;

    private int front = 0;
    private int back = 0;

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

    /** Resizes an array to target capacity */
    private void resize(int capacity) {
        Var[] k = (Var[]) new Object[capacity];
        System.arraycopy(items, 0, k, 0, size);
        items = k;
    }
    /** Adds an item to the front of the Deque. */
    public void addFirst(Var x) {
        if (size == items.length) {
            resize(size * 2);
        }
        if (isEmpty()) {
            items[front] = x;
        }
        else {
            front = (front - 1 + items.length) % items.length;
            items[front] = x;
        }
        back++;
        size += 1;
    }

    /** Adds an item to the back of the Deque. */
    public void addLast(Var x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[back] = x;
        back++;
        size += 1;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. */
    public Var get(int index) {
        if (index > size()) {
            return null;
        }
        return items[index];
    }

    /** Removes and returns the item at the front of the Deque. If no item exists, return null */
    public  Var removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Var removeditem = items[front];
        front = (front + 1) % items.length;
        back--;
        size -= 1;
        return removeditem;
    }

    /** Removes and returns the item at the back of the Deque. If no item exists, return null */
    public Var removeLast() {
        if (isEmpty()) {
            return null;
        }
        Var removeditem = items[back];
        items[back] = null;
        back--;
        size -= 1;
        return removeditem;
    }
    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque() {
        for (int i = 0; i < items.length; i ++) {
            System.out.print(items[i] + " ");
        }
    }

}

