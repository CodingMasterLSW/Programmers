import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int N;
    static int M;
    static int T;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static List<int[]> start = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        start = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    start.add(new int[]{i, j});
                }
            }
        }

        int sum = 0;
        for (int i=0; i<T; i++) {
            bfs();
            cleanDown();
            cleanUp();
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (graph[x][y] == -1) {
                    continue;
                }
                sum += graph[x][y];
            }
        }

        System.out.println(sum);

    }

    public static void bfs() {
        // 임시 그래프
        int[][] tmpGraph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpGraph[i][j] = graph[i][j];
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != -1 && graph[i][j] != 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int startX = poll[0];
            int startY = poll[1];

            int spreadAmount = graph[startX][startY] / 5;
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int ndx = startX + dx[i];
                int ndy = startY + dy[i];

                if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M || tmpGraph[ndx][ndy] == -1) {
                    continue;
                }
                cnt++;
                tmpGraph[ndx][ndy] += spreadAmount;
            }
            tmpGraph[startX][startY] -= (spreadAmount * cnt);
        }
        graph = tmpGraph;
    }

    public static void cleanUp() {
        int upStart = start.get(0)[0];

        // 상단에서 끌어당기기
        for (int i=upStart-1; i>0; i--) {
            graph[i][0] = graph[i-1][0];
        }

        // <- 에서 끌어당기기
        for (int i=0; i<M-1; i++) {
            graph[0][i] = graph[0][i+1];
        }

        // 하단에서 끌어당기기
        for (int i=0; i<upStart; i++) {
            graph[i][M-1] = graph[i+1][M-1];
        }

        // -> 에서 끌어당기기
        for (int i=M-1; i>0; i--) {
            graph[upStart][i] = graph[upStart][i-1];
        }
        // -1 밀린거 복구
        graph[upStart][1] = 0;

    }

    public static void cleanDown() {
        int downStart = start.get(1)[0];

        // 상단에서 끌어당기기
        for (int i = downStart + 1; i < N - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }

        // <- 에서 끌어당기기
        for (int i = 0; i < M - 1; i++) {
            graph[N - 1][i] = graph[N - 1][i + 1];
        }

        // 하단에서 끌어당기기
        for (int i = N - 1; i > downStart; i--) {
            graph[i][M - 1] = graph[i - 1][M - 1];
        }

        // -> 에서 끌어당기기
        for (int i = M-1; i>0; i--) {
            graph[downStart][i] = graph[downStart][i-1];
        }

        // -1 밀린거 복구
        graph[downStart][1] = 0;
    }

}
