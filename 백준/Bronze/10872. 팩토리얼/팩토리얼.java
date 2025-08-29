import java.util.*;

public class Main {

    static int sum = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recursion(N);
        System.out.println(sum);
    }

    private static void recursion(int count) {
        if (count == 0) {
            return;
        }
        sum *= count;
        recursion(count - 1);
    }
}