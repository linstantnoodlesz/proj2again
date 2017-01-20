public class HelloNumbers {
    public static void main(String[] args) {
    	int y = 1;
        int x = 0;
        while (x < 50) {
            System.out.print(x + " ");
            x = x + y;
            y += 1;
        }
    }
}