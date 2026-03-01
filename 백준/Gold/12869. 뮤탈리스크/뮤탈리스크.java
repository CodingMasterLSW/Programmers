import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] arr;
    static boolean[][][] visited = new boolean[61][61][61];
    static int[][] damages = {
        {1, 3, 9}, {1, 9, 3},
        {3, 1, 9}, {3, 9, 1},
        {9, 1, 3}, {9, 3, 1}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(new int[]{arr[0], arr[1], arr[2], 0});
    }

    public static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int[] current = q.poll();

            if (current[0] == 0 && current[1] == 0 && current[2] == 0) {
                System.out.println(current[3]);
                return;
            }

            for (int[] damage : damages) {
                int na = Math.max(0, current[0] - damage[0]);
                int nb = Math.max(0, current[1] - damage[1]);
                int nc = Math.max(0, current[2] - damage[2]);

                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    q.offer(new int[]{na, nb, nc, current[3] + 1});
                }
            }

        }
    }
}