import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N+1][21];

        dp[1][arr[1]] = 1;

        for (int i=2; i<N; i++) {
            for (int j=0; j<=20; j++) {
                if (dp[i-1][j] == 0) {
                    continue;
                }
                int current = j + arr[i];
                if (current >= 0 && current <= 20) {
                    dp[i][current] += dp[i-1][j];
                }

                int current2 = j - arr[i];
                if (current2 >= 0 && current2 <= 20) {
                    dp[i][current2] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-1][arr[N]]);
    }
}