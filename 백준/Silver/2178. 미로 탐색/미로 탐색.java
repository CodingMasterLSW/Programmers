import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] graph;
    static int[][] resultGraph;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        resultGraph = new int[N][M];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                resultGraph[i][j] = -1;
            }
        }

        bfs(0, 0);
        System.out.println(resultGraph[N-1][M-1] + 1);
    }

    public static void bfs(int startDr, int startDc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startDr, startDc});
        resultGraph[startDr][startDc] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i=0; i<4; i++) {
                int ndr = current[0] + dr[i];
                int ndc = current[1] + dc[i];

                if (ndr<0 || ndr >= N || ndc < 0 || ndc >= M) {
                    continue;
                }

                if (graph[ndr][ndc] == 0 || resultGraph[ndr][ndc] != -1) {
                    continue;
                }
                resultGraph[ndr][ndc] = resultGraph[current[0]][current[1]] + 1;

                q.offer(new int[]{ndr, ndc});
            }
        }
    }
}