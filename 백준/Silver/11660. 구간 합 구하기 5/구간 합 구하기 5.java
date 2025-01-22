
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int M;
    static int[][] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];


        // 그래프 초기화
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            dp[i][1] = graph[i-1][0];
        }

        // dp 초기화
        for (int i=1; i<=N; i++) {
            for (int j=2; j<=N; j++) {
                dp[i][j] = dp[i][j-1] + graph[i-1][j-1];
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int start=x1; start<=x2; start++) {
                sum += dp[start][y2] - dp[start][y1-1];
            }
            System.out.println(sum);
        }

    }
}
