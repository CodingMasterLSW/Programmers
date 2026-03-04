import java.io.*;
import java.util.*;

class Main {

    static int[] r = {-2, -2, 0, 0, 2, 2};
    static int[] c = {-1, 1, -2, 2, -1, 1};

    static int[][] graph;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        bfs(new int[]{r1, c1, 0, r2, c2});
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(start);

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentR = current[0];
            int currentC = current[1];
            int cnt = current[2];
            int targetR = current[3];
            int targetC = current[4];

            if (currentR == targetR && currentC == targetC) {
                System.out.println(cnt);
                return;
            }

            for (int i=0; i<6; i++) {
                int nRow = currentR + r[i];
                int nCol = currentC + c[i];

                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) {
                    continue;
                }

                if (visited[nRow][nCol]) {
                    continue;
                }

                visited[nRow][nCol] = true;
                q.offer(new int[]{nRow, nCol, cnt+1, targetR, targetC});
            }

        }
        System.out.println(-1);
    }
}