import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] += dp[i-1] + arr[i];
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                sb.append(dp[b] + "\n");
            } else {
                sb.append(dp[b] - dp[a-1] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}