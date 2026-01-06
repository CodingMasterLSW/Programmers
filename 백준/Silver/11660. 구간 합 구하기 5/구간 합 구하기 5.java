import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] graph;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        dp = new int[N+1][N+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                dp[i][j] += dp[i][j-1] + graph[i-1][j-1];
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            // 여기서 로직 필요
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);

            int result = 0;
            for (int j=minX; j<=maxX; j++) {
                result += dp[j][maxY] - dp[j][minY-1];
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}