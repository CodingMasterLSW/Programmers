import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int count = 0;
    static boolean[] visited;
    static List<List<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        visited[1] = true;

        // arr 초기화
        for (int i=0; i<=N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=1; i<=M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }
        bfs();
        System.out.println(count);
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> connects = arr.get(1);
        for (int connect : connects) {
            q.offer(connect);
            visited[connect] = true;
        }

        while (!q.isEmpty()) {
            count ++;
            Integer poll = q.poll();

            List<Integer> cn = arr.get(poll);

            for (int c : cn) {
                if (visited[c] == false) {
                    q.offer(c);
                    visited[c] = true;
                }
            }
        }
    }
}
