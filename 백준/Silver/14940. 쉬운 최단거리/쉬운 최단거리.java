import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int[] start = findStart(q);
        bfs(q);

        graph[start[0]][start[1]] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    graph[i][j] = -1;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(Queue<int[]> q) {

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];

            for (int i = 0; i < 4; i++) {
                int ndx = x + dx[i];
                int ndy = y + dy[i];

                if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                    continue;
                }
                if (visited[ndx][ndy] || graph[ndx][ndy] != 1) {
                    continue;
                }

                visited[ndx][ndy] = true;
                graph[ndx][ndy] = t + 1;

                q.offer(new int[]{ndx, ndy, t + 1});
            }
        }
    }


    public static int[] findStart(Queue<int[]> q) {
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    start[0] = i;
                    start[1] = j;
                    return start;
                }
            }
        }
        return null;
    }

}
