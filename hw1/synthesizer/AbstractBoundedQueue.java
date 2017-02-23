package synthesizer;

/**
 * Created by gilbertlin on 2/22/17.
 */
public abstract class AbstractBoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }

}
