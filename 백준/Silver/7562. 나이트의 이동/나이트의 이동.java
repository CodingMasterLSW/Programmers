import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] graph;
    static int[] startLocation = new int[2];
    static int[] endLocation = new int[2];

    static boolean[][] visited;

    static int[][] moves = {
        {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2},{1, -2}, {2, -1}, {1, 2}, {2, 1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for (int i=0; i<times; i++) {
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        startLocation[0] = Integer.parseInt(st.nextToken());
        startLocation[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endLocation[0] = Integer.parseInt(st.nextToken());
        endLocation[1] = Integer.parseInt(st.nextToken());

        System.out.println(bfs(startLocation));
        }

    }

    public static int bfs(int[] startLocation) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startLocation[0], startLocation[1], 0});
        visited[startLocation[0]][startLocation[1]] = true;

        while(!q.isEmpty()) {
            int[] currentLocation = q.poll();

            if (currentLocation[0] == endLocation[0] && currentLocation[1] == endLocation[1]) {
                return currentLocation[2];
            }

            for (int i=0; i<moves.length; i++) {
                int ndc = currentLocation[0] + moves[i][0];
                int ndr = currentLocation[1] + moves[i][1];

                if (ndc<0 || ndc >= N || ndr<0 || ndr >= N) {
                    continue;
                }

                if (visited[ndc][ndr]) {
                    continue;
                }
                visited[ndc][ndr] = true;
                q.offer(new int[]{ndc, ndr, currentLocation[2] + 1});
            }
        }
        return -1;
    }
}