import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, L, R;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N][N];
        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int move = move();
        System.out.println(move);
    }

    public static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j]) {
                        int sum = dfs(i, j);
                        if (arr.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) {
                return result;
            }
            result++;
        }

    }

    public static void changePopulation(int sum) {
        int avg = sum / arr.size();
        for (int[] a : arr) {
            int x = a[0];
            int y = a[1];
            graph[x][y] = avg;
        }
    }

    public static int dfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        arr = new ArrayList<>();
        arr.add(new int[] {x, y});

        visited[x][y] = true;
        int sum = graph[x][y];

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int ndx = currentX + dx[i];
                int ndy = currentY + dy[i];

                if (ndx<0 || ndx >=N || ndy<0 || ndy >=N || visited[ndx][ndy]) {
                    continue;
                }

                int calculateResult = Math.abs(graph[currentX][currentY] - graph[ndx][ndy]);

                if (L <= calculateResult && R >= calculateResult) {
                    visited[ndx][ndy] = true;
                    q.offer(new int[]{ndx, ndy});
                    arr.add(new int[]{ndx, ndy});
                    sum += graph[ndx][ndy];
                }
            }
        }
        return sum;
    }

}
