import java.io.*;
import java.util.*;

class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i+1] += dp[i] + arr[i];
        }

        int m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(String.valueOf(dp[b] - dp[a-1])).append("\n");
        }
        System.out.println(sb.toString());
    }
}