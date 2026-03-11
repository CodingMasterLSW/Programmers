import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        long[][] dp = new long[65][11];

        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=64; i++) {
            dp[i][0] = 1;
            for (int j=1; j<10; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int target = Integer.parseInt(br.readLine());

            long sum = 0;
            for (int j=0; j<10; j++) {
                sum += dp[target][j];
            }
            System.out.println(sum);
        }
        
    }
}