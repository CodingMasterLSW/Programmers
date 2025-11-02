import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    public static int bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});

        while(!q.isEmpty()) {
            int[] currentInfos = q.poll();
            int currentLocation = currentInfos[0];
            int currentTime = currentInfos[1];

            if (currentLocation == M) {
                return currentTime;
            }

            if (currentLocation + 1 >= 0 && !visited[currentLocation + 1]) {
                q.offer(new int[]{currentLocation + 1, currentTime + 1});
                visited[currentLocation + 1] = true;
            }
            if (currentLocation - 1 >= 0 && !visited[currentLocation - 1]) {
                q.offer(new int[]{currentLocation - 1, currentTime + 1});
                visited[currentLocation - 1] = true;
            }

            if (currentLocation * 2 >= 0 && currentLocation * 2 <=100_000 && !visited[currentLocation * 2]) {
                q.offer(new int[]{currentLocation * 2, currentTime + 1});
                visited[currentLocation * 2] = true;
            }
        }

        return -1;
    }
}