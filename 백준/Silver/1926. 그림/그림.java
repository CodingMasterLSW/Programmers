import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int max;
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[][] visited; // 각 셀이 방문되었는지 추적

    public static int dfs(int x, int y) {
        //그리드 범위를 벗어나거나 방문한 셀이거나 셀 값이 0이면 0을 반환.
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || graph.get(x).get(y) == 0) {
            return 0;
        }
        visited[x][y] = true;
        // 현재 셀의 값을 1로 설정(현재 셀의 크기)하고, 인접한 네 방향의 셀을 탐색하여 크기를 더함.
        return 1 + dfs(x - 1, y) + dfs(x + 1, y) + dfs(x, y + 1)+dfs(x,y-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(Integer.parseInt(st2.nextToken()));
            }
            graph.add(row);
        }
        cnt = 0;
        max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph.get(i).get(j) == 1) {
                    int size = dfs(i, j);
                    cnt++;
                    if (size > max) {
                        max = size;
                    }
                }

            }

        }
        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}