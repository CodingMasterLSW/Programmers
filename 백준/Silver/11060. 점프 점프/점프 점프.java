import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }


        dp[1] = 0;

        for (int i=1; i<=N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j= i+1; j <= i + arr[i] && j <= N; j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}