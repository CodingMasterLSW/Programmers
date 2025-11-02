import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static boolean[] visited = new boolean[200_001];
    static int[] trace = new int[200_001];
    static Deque<Integer> traces = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));

        calculate(M);
        for (int a : traces) {
            System.out.print(a + " ");
        }
    }
    
    public static void calculate(int end) {
        int current = end;

        while(current != N) {
            traces.push(current);
            current = trace[current];
        }
        traces.push(N);
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

            if (currentLocation * 2 >= 0 && currentLocation * 2 <=200_000 && !visited[currentLocation * 2]) {
                q.offer(new int[]{currentLocation * 2, currentTime + 1});
                visited[currentLocation * 2] = true;
                trace[currentLocation * 2] = currentLocation;
            }

            if (currentLocation + 1 <= 200_000 && !visited[currentLocation + 1]) {
                q.offer(new int[]{currentLocation + 1, currentTime + 1});
                visited[currentLocation + 1] = true;
                trace[currentLocation + 1] = currentLocation;
            }
            
            if (currentLocation - 1 >= 0 && !visited[currentLocation - 1]) {
                q.offer(new int[]{currentLocation - 1, currentTime + 1});
                visited[currentLocation - 1] = true;
                trace[currentLocation - 1] = currentLocation;
            }
        }

        return -1;
    }
}