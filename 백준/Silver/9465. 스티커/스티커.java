import java.io.*;
import java.util.*;

class Main {

    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int z = 0; z < T; z ++) {
            int N = Integer.parseInt(br.readLine());

            dp = new int[3][N];
            graph = new int[2][N];

            for (int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = graph[0][0];
            dp[1][0] = graph[1][0];
            dp[2][0] = 0;

            for (int i=1; i<N; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + graph[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + graph[1][i];
                dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            }
            System.out.println(Math.max(Math.max(dp[0][N-1], dp[1][N-1]), dp[2][N-1]));
        }
    }
}