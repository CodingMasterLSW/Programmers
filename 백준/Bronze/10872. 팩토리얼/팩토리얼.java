import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        for (int i=N; i>0; i--) {
            sum *= i;
        }
        System.out.println(sum);
    }

}