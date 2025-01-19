
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new Integer[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j< i+1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기화 // 4, 5, 2, 6, 6 바닥 초기 설정
        for (int i=0; i<N; i++) {
            dp[N-1][i] = graph[N-1][i];
        }

        System.out.println(find(0, 0));

    }

    static int find(int depth, int idx) {
        if (depth == N-1) {
            return dp[depth][idx];
        }

        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + graph[depth][idx];
        }
        return dp[depth][idx];
    }
}
