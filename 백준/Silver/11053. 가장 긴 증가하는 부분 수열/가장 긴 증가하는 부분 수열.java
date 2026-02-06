import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i=2; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = 0;

        for (int i=1; i<=N; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}