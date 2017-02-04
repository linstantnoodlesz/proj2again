/**
 * Created by gilbertlin on 2/2/17.
 */

import javax.lang.model.element.VariableElement;

/** creates LinkedListDeque, which is a double ended queue formed with LinkedLists */
public class LinkedListDeque <Var> {
    private class ItemNode {
        public Var item;
        public ItemNode next;
        public ItemNode before;

        public ItemNode() {
            item = null;
            next = null;
            before = null;
        }

        public ItemNode(Var i, ItemNode n, ItemNode b) {
            item = i;
            next = n;
            before = b;
        }
    }

    /** creates sentinel node; the first item is found at sentinel.next */
    private class SentinelNode {
        public ItemNode front;
        public ItemNode back;

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

    /** Constructs a LinkedListDeque */
    public LinkedListDeque(Var x) {
        sentinel.front = new ItemNode(x, null, null);
        sentinel.back = sentinel.front;
        size = 1;
    }

    /** adds some x to the front of the list */
    public void addFirst(Var x) {
        ItemNode newFront = new ItemNode(x, sentinel.front, null);
        sentinel.front = newFront;
        size += 1;
    }
    /** adds some x to the back of the list */
    public void addLast(Var x) {
        ItemNode newLast = new ItemNode(x, null, sentinel.back);
        sentinel.back = newLast;
        size += 1;

        }
    /** returns whether a deque is empty or not */
    public boolean isEmpty() {
        if (size()== 0) {
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
     public Var removeFirst() {
        if (sentinel.front.item != null) {
            Var removeditem = sentinel.front.item;
            sentinel.front = sentinel.front.next;
            size -= 1;
            return removeditem;
        }
        return null;
    }
    /** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
    public Var removeLast() {
         if (sentinel.back.item != null) {
             Var removeditem = sentinel.back.item;
             sentinel.back = sentinel.back.before;
             sentinel.back.next = null;
             size -= 1;
             return removeditem;
         }
         return null;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. */
    public Var get(int index) {
        if (index > size()) {
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
    public Var getRecursive(int index) {
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

