import java.io.*;
import java.util.*;


//1) 0 : 전류가 통함, 1: 전류가 안 통함
//2) bfs로 탐색, 이중 반복문으로 탐색하는데, i/2 까지 
//3) i/2~ N까지 탐색하면서, 2가 존재한다면 trye, 없다면 NO


class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;

    static int[] r = {-1, 1, 0, 0};
    static int[] c = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        for (int j=0; j<M; j++) {
            if (!visited[0][j] && graph[0][j] == 0) {
                visited[0][j] = true;
                graph[0][j] = 2;
                bfs(new int[]{0, j});
            }
        }

        boolean flag = false;
        for (int j=0; j<M; j++) {
            if (graph[N-1][j] == 2) {
                flag = true;
                break;
            } 
        }

    
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for (int i=0; i<4; i++) {
                int nrow = r[i] + current[0];
                int ncol = c[i] + current[1];

                if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) {
                    continue;
                }
                if (visited[nrow][ncol]) {
                    continue;
                }
                if (graph[nrow][ncol] == 1) {
                    continue;
                }

                visited[nrow][ncol] = true;
                graph[nrow][ncol] = 2;
                q.offer(new int[]{nrow, ncol});
            }
        }
    }
}