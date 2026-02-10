import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;

    static int[][] graph;
    static boolean[][] visited;
    
    // 우측 대각 -> r -1 , c + 1, 
    static int[] r = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] c = {0, 0, -1, 1, -1, 1, 1, -1};

    static int maxValue = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        visited = new boolean[N][M];

        List<int[]> startPoint = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    startPoint.add(new int[]{i, j, 0});
                }
            }
        }
        bfs(startPoint);
        System.out.println(maxValue);
    }

    public static void bfs(List<int[]> startPoint) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int[] s : startPoint) {
            q.offer(s);
            visited[s[0]][s[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentValue = current[2];

            maxValue = Math.max(maxValue, currentValue);

            for (int i=0; i<8; i++) {
                int nrow = current[0] + r[i];
                int ncol = current[1] + c[i];

                if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) {
                    continue;
                }

                if (visited[nrow][ncol]) {
                    continue;
                }

                visited[nrow][ncol] = true;
                q.offer(new int[]{nrow, ncol, currentValue + 1});
            }
        }
    }
}