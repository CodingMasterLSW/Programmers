
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int m;
    public static int n;
    public static List<Integer> lists = new ArrayList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] graph;
    public static boolean[][] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            graph = new int[m][n]; // 여기서 이미 0으로 초기화
            visited = new boolean[m][n];
            lists.clear();

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x][y] = 1;
            }

            for (int x = 0; x < m; x++) {

                for (int y = 0; y < n; y++) {
                    if (graph[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        lists.add(1);
                    }

                }
            }
            System.out.println(lists.size());

        }

    }

    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        if (graph[x][y] == 0 || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }


}
