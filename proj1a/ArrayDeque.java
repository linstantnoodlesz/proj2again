/**
 * Created by gilbertlin on 2/3/17.
 */
public class ArrayDeque<Item> {
    private Item[] items;

    private int size;

    private int front;
    private int back;

    /** Returns the number of items in the Deque. */
    public int size() {
        return size;
    }
    /** Creates empty ArrayDeque. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        front = (items.length / 2) - 1;
        back = (items.length / 2);
        size = 0;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Resizes an array to target capacity */
    private void resize(int capacity) {
        Item[] k = (Item[]) new Object[capacity];
        System.arraycopy(items, front + 1, k, (k.length - size) / 2, size);
        items = k;
    }
    /** Adds an item to the front of the Deque. */
    public void addFirst(Item x) {
        if (front == -1) {
            resize(items.length * 2);
            front = items.length / 2 - size / 2 - 1;
        }
        items[front] = x;
        front--;
        size++;
    }

    /** Adds an item to the back of the Deque. */
    public void addLast(Item x) {
        if (back == items.length) {
            resize(items.length * 2);
            back = items.length / 2 + (size / 2);
        }
        items[back] = x;
        back++;
        size++;
        System.out.println("Size is now: " + size);
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. */
    public Item get(int index) {
        if (index > size) {
            return null;
        }
        return items[front + 1 + index];
    }

    /** Removes and returns the item at the front of the Deque. If no item exists, return null */
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item removeditem = get(front);
        items[front + 1] = null;
        front++;
        size--;
        return removeditem;
    }

    /** Removes and returns the item at the back of the Deque. If no item exists, return null */
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Item removeditem = get(back);
        System.out.println("back pos is: " + back);
        items[back - 1] = null;
        back--;
        size--;
        return removeditem;
    }

    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }
}


