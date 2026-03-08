import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static char[][] graph;
    static boolean[][] visited;
    static int aliveO = 0;
    static int aliveV = 0;
    

    static int[] r = {-1, 1, 0, 0};
    static int[] c = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();

            for (int j=0; j<M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && graph[i][j] != '#') {
                    visited[i][j] = true;
                    bfs(new int[]{i, j, 0, 0});
                }
            }
        }

        System.out.print(aliveO + " " + aliveV);
    }
    
    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(start);

        int countO = 0;
        int countV = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentR = current[0];
            int currentC = current[1];

            if (graph[currentR][currentC] == 'v') {
                countV++;
            } else if (graph[currentR][currentC] == 'o') {
                countO++;
            }

            for (int i=0; i<4; i++) {
                int nrow = currentR + r[i];
                int ncol = currentC + c[i];

                if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) {
                    continue;
                }

                if (visited[nrow][ncol] || graph[nrow][ncol] == '#') {
                    continue;
                }

                visited[nrow][ncol] = true;
                q.offer(new int[]{nrow, ncol});
            }
        }

        if (countV >= countO) {
            aliveV += countV;
        } else {
            aliveO += countO;
        }


    }
}