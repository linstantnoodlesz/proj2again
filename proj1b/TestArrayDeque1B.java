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
            student.addFirst(input);
            input = StdRandom.uniform(10);
            soln.addFirst(input);
            soln.addFirst(input);
            input = StdRandom.uniform(10);
            student.addLast(input);
            soln.addLast(input);
            student.removeLast();
            soln.removeLast();
            student.removeFirst();
            soln.removeFirst();
            assertEquals(student.get(0), soln.get(0));

        }
    }
}