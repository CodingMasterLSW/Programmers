import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int C;
    
    static int[][] graph;
    static boolean[][] visited;
    static int[] r = {-1, 1, 0, 0};
    static int[] c = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            graph[row][col] = -1;
        }

        int totalMaxValue = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (graph[i][j] != -1 || visited[i][j]) {
                    continue;
                }
                int count = bfs(new int[]{i, j});
                totalMaxValue = Math.max(count, totalMaxValue);
            }
        }
        System.out.println(totalMaxValue);
    }

    public static int bfs(int[] startPoint) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(startPoint);
        visited[startPoint[0]][startPoint[1]] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int nrow = current[0] + r[i];
                int ncol = current[1] + c[i];

                if (nrow<1 || nrow>N || ncol < 1 || ncol > M) {
                    continue;
                }

                if (visited[nrow][ncol]) {
                    continue;
                }

                if (graph[nrow][ncol] != -1) {
                    continue;
                }

                visited[nrow][ncol] = true;

                q.offer(new int[]{nrow, ncol});
                cnt++;
            }
        }
        return cnt;
    }
}