

import java.util.Scanner;

public class Main {

    static int max = 0;
    static int maxCnt = 0;
    static int n;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(input[j]);

                if (graph[i][j] > max) {
                    max = graph[i][j];
                }
            }
        }

        for (int k = 0; k <= max; k++) {
            int[][] tempGraph = new int[n][n];
            visited = new boolean[n][n];
            int currentCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tempGraph[i][j] = graph[i][j]; // 이 부분

                    if (graph[i][j] <= k) {
                        tempGraph[i][j] = 0;
                    }

                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tempGraph[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j, tempGraph);
                        currentCount++;
                    }
                }
            }
            if(currentCount>maxCnt){
                maxCnt = currentCount;
            }
        }
        System.out.println(maxCnt);

    }

    static void dfs(int x, int y, int[][] tempGraph) {
        if (x < 0 || y < 0 || x >=n || y >=n) {
            return;
        }
        if (tempGraph[x][y] == 0 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], tempGraph);
        }
    }
}
