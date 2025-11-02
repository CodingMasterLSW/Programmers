import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};

    static char[][] graph;
    static boolean[][] visited;
    static int[][] fire;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];
        fire = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                fire[i][j] = -1;
            }
        }

        for (int i=0; i<N; i++) {
            String s = br.readLine();

            for (int j=0; j<M; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        List<int[]> fires = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 'F') {
                    fires.add(new int[]{i,j});
                }
            }
        }

        List<int[]> start = new ArrayList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 'J') {
                    start.add(new int[]{i,j});
                }
            }
        }

        fireBfs(fires);

        visited = new boolean[N][M];

        int result = escapeBfs(start.get(0));

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    public static void fireBfs(List<int[]> fires) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int[] f : fires) {
            q.offer(new int[]{f[0], f[1], 1});
            visited[f[0]][f[1]] = true;
            fire[f[0]][f[1]] = 1;
        }

        while(!q.isEmpty()) {
            int[] current = q.poll();
            
            for (int i=0; i<4; i++) {
                int ndc = current[0] + dc[i];
                int ndr = current[1] + dr[i];
                
                if (ndc < 0 || ndc >= N || ndr < 0 || ndr >= M) {
                    continue;
                }

                if (graph[ndc][ndr] == '#' || visited[ndc][ndr]) {
                    continue;
                }
                visited[ndc][ndr] = true;
                fire[ndc][ndr] = current[2] + 1;
                q.offer(new int[]{ndc, ndr, current[2] + 1});             
            }
        }
    }

    public static int escapeBfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 1});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentTime = current[2];

            if (current[0] == 0 || current[0] == N-1 || current[1] == 0 || current[1] == M-1) {
                return currentTime;
            }
            
            for (int i=0; i<4; i++) {
                int ndc = current[0] + dc[i];
                int ndr = current[1] + dr[i];

                if (ndc < 0 || ndc >=N || ndr < 0 || ndr >= M) {
                    continue;
                }

                if (graph[ndc][ndr] == '#' || visited[ndc][ndr]) {
                    continue;
                }

                if (fire[ndc][ndr] != -1 && fire[ndc][ndr] <= currentTime + 1) {
                    continue;
                }

                visited[ndc][ndr] = true;
                q.offer(new int[]{ndc, ndr, currentTime + 1});  
            }
        }
        return -1;
    }
}