
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;
    static int lastCheese = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            Set<int[]> bfs = bfs();
            for (int[] bf : bfs) {
                int x = bf[0];
                int y = bf[1];
                graph[x][y] = 0;
            }

            if (bfs.size() == 0) {
                System.out.println(cnt);
                System.out.println(lastCheese);
                break;
            }
            cnt++;

        }
    }

    public static Set<int[]> bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        Set<int[]> cheeseArr = new HashSet<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int ndx = currentX + dx[i];
                int ndy = currentY + dy[i];

                if (ndx<0 || ndx>=N || ndy<0 || ndy>=M || visited[ndx][ndy]) {
                    continue;
                }

                visited[ndx][ndy] = true;

                if (graph[ndx][ndy] == 1) {
                    cheeseArr.add(new int[] {ndx, ndy});
                    continue;
                }
                q.offer(new int[]{ndx, ndy});
            }
        }
        if (cheeseArr.size() == 0) {
            return cheeseArr;
        }
        lastCheese = cheeseArr.size();
        return cheeseArr;
    }
}
