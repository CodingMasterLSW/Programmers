import java.io.*;
import java.util.*;

public class Main {

    static boolean[][][] visited;
    static char[][][] graph;
    static int K;
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if(cnt>0){
                br.readLine();
            }
            cnt++;
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (K == 0 && N == 0 && M == 0) {
                break;
            }

            graph = new char[K][N][M];
            visited = new boolean[K][N][M];

            for (int z = 0; z < K; z++) {
                if (z > 0) {
                    br.readLine();
                }
                for (int i = 0; i < N; i++) {
                    String s = br.readLine();
                    for (int j = 0; j < M; j++) {
                        graph[z][i][j] = s.charAt(j);
                    }
                }
            }

            int bfs = bfs();
            if (bfs == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println(String.format("Escaped in %d minute(s).", bfs));
            }
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        findStart(q);

        while (!q.isEmpty()) {
            int[] current = q.poll();

            int z = current[0];
            int x = current[1];
            int y = current[2];
            int minutes = current[3];

            if (graph[z][x][y] == 'E') {
                return minutes;
            }

            for (int i = 0; i < 6; i++) {
                int ndz = z + dz[i];
                int ndx = x + dx[i];
                int ndy = y + dy[i];

                if (ndz < 0 || ndz >= K || ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                    continue;
                }

                // 방문 여부와 벽 확인
                if (visited[ndz][ndx][ndy] || graph[ndz][ndx][ndy] == '#') {
                    continue;
                }

                q.add(new int[]{ndz, ndx, ndy, minutes + 1});
                visited[ndz][ndx][ndy] = true;
            }
        }
        return -1;
    }

    public static void findStart(Queue<int[]> q) {
        for (int z = 0; z < K; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[z][i][j] == 'S') {
                        q.add(new int[]{z, i, j, 0});
                        visited[z][i][j] = true;
                        return;
                    }

                }
            }
        }
    }
}
