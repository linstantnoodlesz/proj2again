/**
 * Created by gilbertlin on 2/2/17.
 */

/** creates LinkedListDeque, which is a double ended queue formed with LinkedLists */
public class LinkedListDeque <Item> {
    private class ItemNode {
        public Item item;
        public ItemNode next;
        public ItemNode before;

        public ItemNode() {
            item = null;
            next = null;
            before = null;
        }

        public ItemNode(Item i, ItemNode n, ItemNode b) {
            item = i;
            next = n;
            before = b;
        }
    }

    /** creates sentinel node; the first item is found at sentinel.next */
    private class SentinelNode {
        private ItemNode front;
        private ItemNode back;
        public ItemNode getFront() {
            return front;
        }
        public ItemNode getBack() {
            return back;
        }

    }
    private int size;
    private SentinelNode sentinel;

    /** returns the variable size (incremented across multiple methods) */
    public int size() {
        return size;
    }

    /** creates empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new SentinelNode();
        sentinel.front = null;
        sentinel.back = null;
        size = 0;
    }

    /** adds some x to the front of the list */
    public void addFirst(Item x) {
        ItemNode newFront = new ItemNode(x, sentinel.front, null);
        sentinel.front = newFront;
        size += 1;
    }
    /** adds some x to the back of the list */
    public void addLast(Item x) {
        ItemNode newLast = new ItemNode(x, null, sentinel.back);
        sentinel.back = newLast;
        size += 1;
        }

    /** returns whether a deque is empty or not */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque() {
        System.out.print(sentinel.front + " ");
        ItemNode p = sentinel.front;
        while (p.next != null) {
            System.out.print(p.next + " ");
            p = p.next;
        }
    }

    /** Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
     public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
         Item removeditem = sentinel.front.item;
         sentinel.front = sentinel.front.next;
         size -= 1;
         return removeditem;
    }
    /** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
    public Item removeLast() {
         if (isEmpty()) {
             return null;
         }
         Item removeditem = sentinel.back.item;
         sentinel.back = sentinel.back.before;
         sentinel.back.next = null;
         size -= 1;
         return removeditem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. */
    public Item get(int index) {
        if (index > size) {
            return null;
        }
        int k = 0;
        ItemNode p = sentinel.front;
        while (k != index) {
            p = p.next;
            k++;
        }
        return p.item;
    }
    /** same as get(int index) but uses recursion */
    public Item getRecursive(int index) {
        ItemNode p = sentinel.front;
        ItemNode k = sentinel.front;
        if (index > size) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        k = p.next;
        return getRecursive(index - 1);
    }

}

