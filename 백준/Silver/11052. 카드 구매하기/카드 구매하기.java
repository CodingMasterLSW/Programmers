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
        }

        dp[0] = 0;
        dp[1] = arr[1];

        // i = 2, 3, 4
        for (int i=2; i<=N; i++) {
            // dp[1] + arr[1], dp[0] + arr[2];
            for (int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i-j] + arr[j], dp[i]);
            }
        }
        
        System.out.println(dp[N]);
    }
}