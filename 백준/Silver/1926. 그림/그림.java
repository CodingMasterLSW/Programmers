import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int cnt;
    static int maxSize;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    int currentSize = dfs(i, j, graph, visited);
                    if(currentSize>maxSize){
                        maxSize = currentSize;
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxSize);
    }

    public static int dfs(int x, int y, int[][] graph, boolean[][] visited) {

        // 정상 범위 체크
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return 0;
        }
        // 이미 방문 했다면 방문X
        if (visited[x][y] || graph[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;
        int currentSize = 1;

        for (int i = 0; i < 4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];
            currentSize += dfs(ndx, ndy, graph, visited);
        }

        return currentSize;
    }

}
