import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] graph;
    static int[][] dp;
    static int minValue = Integer.MAX_VALUE - 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N+1][4];
        dp = new int[N+1][4];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=1; j<=3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for (int first=1; first<=3; first++) {
            dp = new int[N+1][4];

            dp[1][1] = Integer.MAX_VALUE - 100000;
            dp[1][2] = Integer.MAX_VALUE - 100000;
            dp[1][3] = Integer.MAX_VALUE - 100000;
            dp[1][first] = graph[1][first];

            for (int i=2; i<=N; i++) {
                dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + graph[i][1];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + graph[i][2];
                dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + graph[i][3];
            }

            for (int i=1; i<=3; i++) {
                if (i==first) {
                    continue;
                }
                minValue = Math.min(dp[N][i], minValue);
            }
        }

        System.out.println(minValue);

    }
}