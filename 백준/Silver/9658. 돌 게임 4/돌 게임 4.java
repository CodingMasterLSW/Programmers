import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        if (N <= 4) {
            if (N == 1) {
                System.out.println("CY");
            } else if (N == 2) {
                System.out.println("SK");
            } else if (N == 3) {
                System.out.println("CY");
            } else if (N == 4) {
                System.out.println("SK");
            }
            return;
        }
        
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 1;

        for (int i=5; i<=N; i++) {
            if (dp[i-1] == 0 || dp[i-3] == 0 || dp[i-4] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }

        if (dp[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }
}