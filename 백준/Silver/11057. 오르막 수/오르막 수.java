import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[1001][11];

        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=1000; i++) {
            for (int j=0; j<10; j++) {
                if (j==0) {
                    dp[i][j] = (dp[i-1][j]) % 10007;
                } else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
                }
            }
        }

        long sum = 0;
        for (int i=0; i<10; i++) {
            sum = (sum + dp[N][i]) % 10007;
        }
        System.out.println(sum);
        
    }
}