//TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency.
        buffer = new ArrayRingBuffer((int) Math.round(SR / frequency));
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() throws RuntimeException {
        // TODO: Dequeue the buffer, and replace it with random numbers between -0.5 and 0.5.
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() throws RuntimeException {
        // TODO: Dequeue front sample and enqueue a new sample.
        double d1 = buffer.dequeue();
        double d2 = buffer.peek();
        buffer.enqueue(0.996 * (0.5) * (d1 + d2));
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        return buffer.peek();
    }
}
