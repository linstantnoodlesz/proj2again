/**
 * Created by gilbertlin on 2/10/17.
 */
public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        N = N;
    }
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == N) {
            return true;
        }
        return false;
    }
}
