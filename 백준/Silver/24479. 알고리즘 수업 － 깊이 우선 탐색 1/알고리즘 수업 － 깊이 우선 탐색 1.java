import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int R;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (List<Integer> node : graph) {
            Collections.sort(node);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=visited.length-1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int node) {
        visited[node] = cnt;

        for (int i=0; i<graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i);
            if (visited[newNode] == 0) {
                cnt++;
                dfs(newNode);
            }
        }
    }
}
