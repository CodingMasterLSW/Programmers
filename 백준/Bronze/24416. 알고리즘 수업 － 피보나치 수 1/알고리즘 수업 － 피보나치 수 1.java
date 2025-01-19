import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = fib(N);
        System.out.print(res);

        int[] dp = new int[41];

        dp[1] = 1;
        dp[2] = 1;
        int cnt = 0;
        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            cnt++;
        }
        System.out.print(" " + cnt);

    }

    public static int fib(int n) {
        if (n==1 || n==2) {
            return 1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

}
