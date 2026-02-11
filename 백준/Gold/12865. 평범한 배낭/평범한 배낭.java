import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int[] W;
    static int[] V;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N];
        V = new int[N];


        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][K+1];

        // 첫줄 초기화
        for (int i=0; i<=K; i++) {
            if (W[0] <= i) {
                dp[0][i] = V[0];
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i=1; i<N; i++) {
            for (int j=0; j<=K; j++) {
                if (W[i] > j) {
                    // 큰 경우
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i]] + V[i]);
                }
                
            }
        }
        System.out.println(dp[N-1][K]);

    }
}