import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int T;

    static int[] r = {-1, 1, 0, 0};
    static int[] c = {0, 0, -1, 1};
    
    static boolean[][][] visited;
    static int[][] graph;

    static int minValue = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(new int[]{0, 0, 0, 0});

        if (minValue == Integer.MAX_VALUE) {
            System.out.println("Fail");
            return;
        }
        System.out.println(minValue);
    }

    public static void bfs(int[] startPoint) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(startPoint);
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int currentValue = current[2];
            int hasSword = current[3]; // 0이면 검 없음, 1이면 검 있음

            if (currentValue > T) {
                return;
            }

            if (row == N-1 && col == M-1) {
                minValue = Math.min(minValue, currentValue);
                return;
            } 

            for (int i=0; i<4; i++) {
                int nrow = current[0] + r[i];
                int ncol = current[1] + c[i];
  

                if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) {
                    continue;
                }

                int nextSword = hasSword;

                if (graph[nrow][ncol] == 2) {
                    nextSword = 1;
                }

                if (visited[nrow][ncol][hasSword]) {
                    continue;
                }

                if (graph[nrow][ncol] == 1 && nextSword == 0) {
                    continue;
                } 

                visited[nrow][ncol][nextSword] = true;

                q.offer(new int[]{nrow, ncol, currentValue + 1, nextSword});
            }
        }
    }
}