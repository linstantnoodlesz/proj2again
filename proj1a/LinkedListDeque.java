/**
 * Created by gilbertlin on 2/2/17.
 */

import javax.lang.model.element.VariableElement;

/** creates LinkedListDeque, which should be a double ended queue formed with LinkedLists */
public class LinkedListDeque <Var> {
    private class ItemNode {
        public Var item;
        public ItemNode next;

        public ItemNode(Var i, ItemNode n) {
            item = i;
            next = n;
        }
    }
    /** creates sentinel node; the first item is found at sentinel.next */
    private ItemNode sentinel;
    private int size;

    /** returns the variable size (incremented across multiple methods) */
    public int size() {
        return size;
    }

    /** creates empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new ItemNode(null, null);
        size = 0;
    }

    /** Constructs the LinkedListDeque class */
    public LinkedListDeque(Var x) {
        sentinel = new ItemNode(null,null);
        sentinel.next = new ItemNode(x, null);
        size = 1;
    }

    /** adds some x to the front of the list */
    public void addFirst(Var x) {
        sentinel.next = new ItemNode(x, sentinel.next);
        size += 1;
    }
}
