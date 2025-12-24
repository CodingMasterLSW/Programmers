import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static char[][] graph;
    static Set<Character> histories;
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
        histories = new HashSet<>();
        histories.add(graph[0][0]);
        backtracking(0,0);
        System.out.println(maxValue);
    }

    public static void backtracking(int x, int y) {
        maxValue = Math.max(maxValue, histories.size());

        // 조기 종료 (최적화)
        if (histories.size() == 26) {
            return;
        }

        for (int i=0; i<4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];

            if (ndx < 0 || ndx >= N || ndy < 0 || ndy >= M) {
                continue;
            }

            if (histories.contains(graph[ndx][ndy])) {
                continue;
            }

            histories.add(graph[ndx][ndy]);
            backtracking(ndx, ndy);
            histories.remove(graph[ndx][ndy]);
        }
    }

}