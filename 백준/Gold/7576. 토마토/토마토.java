import java.io.*;
import java.util.*;

class Main {

    static int M;
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int count = 0;

    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(findStart());
        boolean hasZero = false;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 0) {
                    hasZero = true;
                    break;
                }
            }
        }
        if (hasZero) {
            System.out.println("-1");
        } else {
            System.out.println(count);
        }

    }

    public static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int ndc = current[0] + dc[i];
                int ndr = current[1] + dr[i];
                int day = current[2];

                if (ndc < 0 || ndc >= N || ndr < 0 || ndr >= M) {
                    continue;
                }

                if (graph[ndc][ndr] != 0 || visited[ndc][ndr]) {
                    continue;
                }

                visited[ndc][ndr] = true;
                graph[ndc][ndr] = 1;
                q.offer(new int[]{ndc, ndr, day + 1});
                count = Math.max(day + 1, count);
            }
        }
    }

    public static Queue<int[]> findStart(){
        Queue<int[]> q = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        return q;
    }
}