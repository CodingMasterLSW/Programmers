import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int k = sc.nextInt();

        visited = new boolean[c + 1];

        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
             graph.get(x).add(y);
                graph.get(y).add(x);
            }

        for (int i = 0; i < c; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(1);
        System.out.println(cnt - 1);

    }

    static void dfs(int node) {
        visited[node] = true;
        cnt++;

        for (int i : graph.get(node)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
