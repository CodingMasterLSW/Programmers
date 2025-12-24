import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static char[][] graph;
    static boolean[] visited;
    static int maxValue = 0;

    static int[] dx = {-1, 1, 0, 0,};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<input.length(); j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        visited = new boolean[26];
        visited[graph[0][0] - 'A'] = true;
        backtracking(0,0, 1);
        System.out.println(maxValue);
    }

    public static void backtracking(int x, int y, int size) {
        maxValue = Math.max(maxValue, size);

        // 조기 종료 (최적화)
        if (size == 26) {
            return;
        }

        for (int i=0; i<4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];

            if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                continue;
            }

            int charIdx = graph[ndx][ndy] - 'A';

            if (visited[charIdx]) {
                continue;
            }
            visited[charIdx] = true;
            backtracking(ndx, ndy, size + 1);
            visited[charIdx] = false;
        }
    }

}