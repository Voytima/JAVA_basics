import java.util.Scanner;

public class TriangleNum {
        public static String recursion(int n) {
            int start;
            int num_rec = 1;

            if (n == 0) {
                System.out.print("Start -->");
            } else {
                for (start = 1; start < n + 1; start++) {
                    num_rec = start * (start + 1) / 2;
                }
                System.out.print(recursion(--n) + " " + num_rec);
            }
            return "";
        }

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");
            int n = in.nextInt();
            recursion(n);
        }
}
