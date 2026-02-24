import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][10_005];

        dp[0][0] = 1;

        for (int i=1; i<=3; i++) {
            for (int j=0; j<=10_000; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-i >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-i];
                }
            }
        }
        
        for (int i=0; i<T; i++) {
            int target = Integer.parseInt(br.readLine());
            System.out.println(dp[3][target]);
        }
        
    }
}