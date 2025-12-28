import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] areas;
    static boolean[] visited;
    static int[] history;

    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        areas = new int[N][N];

        history = new int[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                areas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;

        backtracking(1);
        System.out.println(minValue);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            int currentValue = 0;
            for (int i=0; i<N-1; i++) {
                int start = history[i];
                int end = history[i+1];

                int destinationValue = areas[start][end];
                if (destinationValue == 0) {
                    return;
                }
                currentValue += destinationValue;
            }
            int start = history[N-1];
            int destinationValue = areas[start][0];
            if (destinationValue == 0) {
                return;
            } 
            currentValue += destinationValue;
            minValue = Math.min(currentValue, minValue);
        }

        for (int i=1; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            history[depth] = i;
            backtracking(depth + 1);
            visited[i] = false;
        }
    }
}