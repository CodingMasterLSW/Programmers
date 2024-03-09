
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph;
    static boolean[][] visited;
    static int m;
    static int n;
    static int k;
    static int cnt;
    static List<Integer> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());
        n = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int x = 0; x < k; x++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st2.nextToken());
            int startY = Integer.parseInt(st2.nextToken());
            int endX = Integer.parseInt(st2.nextToken());
            int endY = Integer.parseInt(st2.nextToken());

            for (int i = startY; i < endY; i++) {
                for (int j = startX; j < endX; j++) {
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    int area = dfs(i, j);
                    lists.add(area);
                    cnt++;
                }
            }
        }

        Collections.sort(lists);
        bw.write(String.valueOf(cnt));
        bw.newLine();
        for (
                Integer num : lists) {
            bw.write(String.valueOf(num)+" ");

        }
        bw.flush();
        bw.close();
    }


    public static int dfs(int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }
        if (graph[x][y] == 1 || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;

        int calculateArea = 1;

        for (int i = 0; i < 4; i++) {
            calculateArea += dfs(x + dx[i], y + dy[i]);
        }
        return calculateArea;
    }

}
