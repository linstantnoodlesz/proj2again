/**
 * Created by gilbertlin on 2/10/17.
 */
public class OffByN implements CharacterComparator {
    private int x;

    public OffByN(int N) {
        x = N;
    }
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == x) {
            return true;
        }
        return false;
    }
}
