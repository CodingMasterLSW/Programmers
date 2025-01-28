
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> start = new ArrayList<>();
    static int N;
    static int M;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    start.add(new int[]{i, j});
                }

            }
        }

        for (int i=0; i<T; i++) {
            bfs();
            cleanDown();
            cleanUp();
        }

        int sum = 0;
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                if (graph[a][b] == -1) {
                    continue;
                }
                sum += graph[a][b];
            }
        }
        System.out.println(sum);
    }

    public static void bfs() {
        Queue<int[]> nextDust = new ArrayDeque<>();

        int[][] tmpGraph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpGraph[i][j] = graph[i][j];
                if (graph[i][j] != 0 && graph[i][j] != -1) {
                    nextDust.add(new int[]{i, j});
                }
            }
        }

        while (!nextDust.isEmpty()) {
            int[] current = nextDust.poll();
            int currentX = current[0];
            int currentY = current[1];

            int spreadAmount = graph[currentX][currentY] / 5;
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int ndx = currentX + dx[i];
                int ndy = currentY + dy[i];

                if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M || tmpGraph[ndx][ndy] == -1) {
                    continue;
                }
                tmpGraph[ndx][ndy] += spreadAmount;
                cnt++;
            }

            tmpGraph[currentX][currentY] -= (spreadAmount * cnt);

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = tmpGraph[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] > 0) {
                    nextDust.add(new int[]{i, j});
                }
            }
        }
    }
/*
    public static void cleanUp() {
        int up = start.get(0)[0];

        // 하단
        for (int i=0; i<up; i++) {
            graph[up-i][0] = graph[up-1-i][0];
        }
        graph[up][0] = -1;

        // <- (clear)
        for (int i=0; i<M-1; i++) {
            graph[0][i] = graph[0][i+1];
        }

        // 상단
        for (int i=0; i<up; i++) {
            graph[i][M-1] = graph[i+1][M-1];
        }

        for (int i=0; i<M-1; i++) {
            graph[up][M-1-i] = graph[up][M-2-i];
        }
        graph[up][1] = 0;
    }

    public static void cleanDown() {
        int down = start.get(1)[0];

        // 상단
        for (int i=down; i<N-1; i++) {
            graph[i][0] = graph[i+1][0];
        }

        // 공기청정기 좌표 다시 설정
        graph[down][0] = -1;

        // <- (clear)
        for (int i=0; i<M-1; i++) {
            graph[N-1][i] = graph[N-1][i+1];
        }

        // 하단 (clear)
        for (int i=0; i<down; i++) {
            graph[N-1-i][M-1] = graph[N-2-i][M-1];
        }
        // -> (clear)
        for (int i=0; i<M-1; i++) {
            graph[down][M-1-i] = graph[down][M-2-i];
        }
        graph[down][1] = 0;
    }
    
 */
public static void cleanUp() {
    int up = start.get(0)[0];

    // 위쪽 공기청정기 (반시계 방향)
    // 아래로 당기기
    for (int i = up - 1; i > 0; i--) {
        graph[i][0] = graph[i - 1][0];
    }
    // 왼쪽으로 당기기
    for (int i = 0; i < M - 1; i++) {
        graph[0][i] = graph[0][i + 1];
    }
    // 위로 당기기
    for (int i = 0; i < up; i++) {
        graph[i][M - 1] = graph[i + 1][M - 1];
    }
    // 오른쪽으로 당기기
    for (int i = M - 1; i > 1; i--) {
        graph[up][i] = graph[up][i - 1];
    }
    // 공기청정기에서 나오는 바람은 미세먼지가 없음
    graph[up][1] = 0;
}

    public static void cleanDown() {
        int down = start.get(1)[0];

        // 아래쪽 공기청정기 (시계 방향)
        // 위로 당기기
        for (int i = down + 1; i < N - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }
        // 왼쪽으로 당기기
        for (int i = 0; i < M - 1; i++) {
            graph[N - 1][i] = graph[N - 1][i + 1];
        }
        // 아래로 당기기
        for (int i = N - 1; i > down; i--) {
            graph[i][M - 1] = graph[i - 1][M - 1];
        }
        // 오른쪽으로 당기기
        for (int i = M - 1; i > 1; i--) {
            graph[down][i] = graph[down][i - 1];
        }
        // 공기청정기에서 나오는 바람은 미세먼지가 없음
        graph[down][1] = 0;
    }

}
