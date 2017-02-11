/**
 * Created by gilbertlin on 2/9/17.
 */

/** contains methods shared by ArrayDeque and LinkedListDeque */
public interface Deque <Item> {
    void addFirst(Item x);
    void addLast(Item x);
    boolean isEmpty();
    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
    Item getRecursive(int index);
}
