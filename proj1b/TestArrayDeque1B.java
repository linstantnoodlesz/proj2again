/**
 * Created by gilbertlin on 2/6/17.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    @Test
    public void tester() {
        int input = StdRandom.uniform(10);
        StudentArrayDeque student = new StudentArrayDeque();
        ArrayDequeSolution soln = new ArrayDequeSolution();
        boolean value_agree = true;
        while (value_agree) {
            student.addFirst(input);
            soln.addFirst(input);
            assertEquals(soln.get(0), student.get(0));
            input = StdRandom.uniform(10);
            student.addFirst(input);
            soln.addFirst(input);
            assertEquals(soln.get(0), student.get(0));
            input = StdRandom.uniform(10);
            student.addLast(input);
            soln.addLast(input);
            input = StdRandom.uniform(10);
            student.addLast(input);
            soln.addLast(input);
            assertEquals(soln.removeFirst(), student.removeFirst());
            assertEquals(soln.removeLast(), student.removeLast());
            }
        }

}