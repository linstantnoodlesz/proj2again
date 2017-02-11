/*** Created by gilbertlin on 2/6/17. */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void tester() {
        int input = StdRandom.uniform(10);
        StudentArrayDeque student = new StudentArrayDeque();
        ArrayDequeSolution soln = new ArrayDequeSolution();

        String string = "";
        int sizeTo = 4;
        while (sizeTo > 0) {
            student.addFirst(input);
            soln.addFirst(input);
            string += "\naddFirst(" + input + ")";

            input = StdRandom.uniform(10);
            student.addFirst(input);
            soln.addFirst(input);
            string += "\naddFirst(" + input + ")";

            input = StdRandom.uniform(10);
            student.addLast(input);
            soln.addLast(input);
            string += "\naddLast(" + input + ")";

            input = StdRandom.uniform(10);
            student.addLast(input);
            soln.addLast(input);
            string += "\naddLast(" + input + ")";
            sizeTo--;
        }

        while (soln.size() > 0) {
            assertEquals(string + "\nremoveFirst()", soln.removeFirst(), student.removeFirst());
            string += "\nremoveFirst()";
            assertEquals(string + "\nremoveLast()", soln.removeLast(), student.removeLast());
            string += "\nremoveLast()";
        }
    }

}