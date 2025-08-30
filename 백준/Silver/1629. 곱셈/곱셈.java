import java.util.*;

public class Main {

    static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(recursion(A, B));
    }

    private static long recursion(long A, long B) {
        if (B == 1) {
            return A % C;
        }

        long result = recursion(A, B/2);

        if (B % 2 == 1) {
            return ((result * result % C) * (A % C)) % C;
        }
        return result * result % C;

    }

}
