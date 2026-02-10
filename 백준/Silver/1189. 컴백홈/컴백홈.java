import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int K;
    static char[][] graph;
    static boolean[][] visited;
    static int[] r = {-1, 1, 0, 0};
    static int[] c = {0, 0, -1, 1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        dfs(new int[]{N-1, 0, 1});
        System.out.println(cnt);
        
    }

    public static void dfs(int[] startPoint) {
        int row = startPoint[0];
        int col = startPoint[1];
  
        visited[row][col] = true;

        if (row == 0 && col == M-1) {
            if (startPoint[2] == K) {
                cnt++;
            }
            visited[row][col] = false;
            return;
        }

        for (int i=0; i<4; i++) {
            int nrow = row + r[i];
            int ncol = col + c[i];

            if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) {
                continue;
            }

            if (visited[nrow][ncol]) {
                continue;
            }

            if (graph[nrow][ncol] == 'T') {
                continue;
            }

            dfs(new int[]{nrow, ncol, startPoint[2] + 1});
        }

        visited[row][col] = false;
    }

}
