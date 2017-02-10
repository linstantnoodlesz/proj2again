/**
 * Created by gilbertlin on 2/9/17.
 */
public class Palindrome {

    /** adds words letter by letter to a Deque in order */
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> newDeque = new ArrayDequeSolution<>();
        adder(word, newDeque);
        return newDeque;
    }
    /** helper method for wordToDeque */
    public static void adder(String word, Deque deque) {
        if (word.length() == 0) {
            return;
        }
        else {
            deque.addFirst(word.charAt(word.length() - 1));
            adder(word.substring(0, word.length() - 1), deque);
        }
    }
    /** adds a word in reverse order letter by letter to a Deque */
    public static Deque<Character> wordToDequeBack(String word) {
        Deque<Character> newDeque = new ArrayDequeSolution<>();
        backwardsadder(word, newDeque);
        return newDeque;
    }
    /** helper method for wordtoDequeBack */
    public static void backwardsadder(String word, Deque deque) {
        if (word.length() == 0) {
            return;
        } else {
            deque.addLast(word.charAt(word.length() - 1));
            backwardsadder(word.substring(0, word.length() - 1), deque);
        }
    }

    /** Returns whether a worid is a palindrome or not */
    public static boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int k = 0;
        while (k != word.length()) {
            if (wordToDeque(word).get(k) != (wordToDequeBack(word).get(k))) {
                return false;
            }
            k++;
        }
        return true;
    }
}
