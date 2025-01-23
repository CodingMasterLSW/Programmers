import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0};
    static int[] dy = {0, -1, 1};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int count = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }
            graph = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        count++;
                    }
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        if (graph[x][y] != 1) {
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            for (int j = 0; j < dy.length; j++) {
                int ndx = x + dx[i];
                int ndy = y + dy[j];

                // 자기 자신 제외
                if (dx[i] == 0 && dy[i] == 0) {
                    continue;
                }

                if (ndx < 0 || ndx >= M || ndy < 0 || ndy >= N) {
                    continue;
                }

                if (visited[ndx][ndy] || graph[ndx][ndy] != 1) {
                    continue;
                }

                visited[ndx][ndy] = true;
                dfs(ndx, ndy);
            }
        }
    }
}
