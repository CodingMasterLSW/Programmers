import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] graph;
    static int[] r = {-1, 1, 0 ,0};
    static int[] c = {0, 0, -1, 1};
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(true) {
            result++;
            int[][] copyGraph = new int[N][M];
            visited = new boolean[N][M];

            for (int i=0; i<N; i++) {
                copyGraph[i] = Arrays.copyOf(graph[i], M);
            }
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (graph[i][j] == 0) {
                        continue;
                    }
                    int cnt = cal(i, j);
                    copyGraph[i][j] -= cnt;
                    if (copyGraph[i][j] < 0) {
                        copyGraph[i][j] = 0;
                    }
                }
            }
            graph = copyGraph;
            
            int cnt = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (graph[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            if (cnt >= 2) {
                System.out.println(result);
                break;
            }
            if (cnt == 0) {
                System.out.println(0);
                break;
            }
        }
    }

    public static void bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startR, startC});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i=0; i<4; i++) {
                int nRow = current[0] + r[i];
                int nCol = current[1] + c[i];

                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) {
                    continue;
                }

                if (visited[nRow][nCol]) {
                    continue;
                }

                if (graph[nRow][nCol] == 0) {
                    continue;
                }

                visited[nRow][nCol] = true;
                q.offer(new int[]{nRow, nCol});
            }
        }
    }

    public static void print(int[][] copyGraph) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(copyGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int cal(int inRow, int inCol) {
        int cnt = 0;
        for (int i=0; i<4; i++) {
            int nrow = r[i] + inRow;
            int ncol = c[i] + inCol;
            if (graph[nrow][ncol] == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}