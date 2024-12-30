import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int currentMax = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                anotherCase(i, j);
            }
        }
        System.out.println(currentMax);
    }

    public static void anotherCase(int x, int y) {
        int sum = 0;

        // 상, 하, 좌
        if (x - 1 >= 0 && x + 1 < N && y - 1 >= 0) {
            sum = Math.max(sum, arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1]);
        }
        // 상, 하, 우
        if (x - 1 >= 0 && x + 1 < N && y + 1 < M) {
            sum = Math.max(sum, arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1]);
        }
        // 상, 좌, 우
        if (x - 1 >= 0 && y - 1 >= 0 && y + 1 < M) {
            sum = Math.max(sum, arr[x][y] + arr[x - 1][y] + arr[x][y - 1] + arr[x][y + 1]);
        }

        // 하, 좌, 우
        if (x + 1 < N && y + 1 < M && y - 1 >= 0) {
            sum = Math.max(sum, arr[x][y] + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1]);
        }
        currentMax = Math.max(currentMax, sum);
    }

    public static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            currentMax = Math.max(currentMax, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];

            if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                continue;
            }
            if (visited[ndx][ndy]) {
                continue;
            }
            visited[ndx][ndy] = true;
            dfs(ndx, ndy, count + 1, sum + arr[ndx][ndy]);
            visited[ndx][ndy] = false;
        }
    }

}
