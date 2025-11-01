import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int maxSize = 0;
    static int totalArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    maxSize = Math.max(maxSize, bfs(i, j));
                    totalArea++;
                }
            }
        }
        System.out.println(totalArea);
        System.out.println(maxSize);
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});

        visited[startX][startY] = true;

        int count = 0;

        while (!q.isEmpty()) {
            count++;
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr < 0 || nr >=N || nc < 0 || nc >= M) {
                    continue;
                }
                if (visited[nr][nc] || graph[nr][nc] == 0) {
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return count;
    }
}