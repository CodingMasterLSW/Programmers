import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static List<int[]> answer = new ArrayList<>();
    static boolean[] visited;
    static int currentMin = Integer.MAX_VALUE;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    homes.add(new int[] {i, j});
                } else if (graph[i][j] == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }
        visited = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(currentMin);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int[] home : homes) {
                int cal = Integer.MAX_VALUE;
                for (int[] ans : answer) {
                    cal = Math.min(cal, (Math.abs(ans[0] - home[0]) + Math.abs(ans[1] - home[1])));
                }
                sum += cal;
            }
            currentMin = Math.min(sum, currentMin);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(chickens.get(i));
                dfs(depth + 1, i+1);
                visited[i] = false;
                answer.remove(answer.size()-1);
            }
        }
    }
}
