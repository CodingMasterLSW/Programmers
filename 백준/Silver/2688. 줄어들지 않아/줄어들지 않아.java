import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        long[][] dp = new long[65][11];

        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=64; i++) {
            for (int j=0; j<10; j++) {
                for (int k=0; k<=j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
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