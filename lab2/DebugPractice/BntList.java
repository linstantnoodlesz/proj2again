/**
 * Created by gilbertlin on 2/13/17.
 */
public class BntList {
    public int val;
    public BntList tail;

    public BntList(int val, BntList tail) {
        this.val = val;
        this.tail = tail;
    }

    public static void next1(BntList list) {
        list = list.tail;
    }

    public static BntList next2(BntList list) {
        list = list.tail;
        return list;
    }

    public static void next3(BntList list) {
        BntList temp = list;
        temp = temp.tail;
    }

    public static void main(String[] args) {
        BntList L = new BntList(1, null);
        L = new BntList(2, L);
        L = new BntList(3, L);
        next1(L);
        System.out.println(L.val);
        next2(L);
        System.out.println(L.val);
        next3(L);
        System.out.println(L.val);
    }

}