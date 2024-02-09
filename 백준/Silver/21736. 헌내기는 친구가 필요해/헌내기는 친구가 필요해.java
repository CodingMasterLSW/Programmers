
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int startX, startY;
    static int m;
    static int n;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());
        n = Integer.parseInt(st1.nextToken());

        graph = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
                if (graph[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(startX, startY);

        if(cnt==0){
            bw.write(String.valueOf("TT"));
        } else{
            bw.write(String.valueOf(cnt));
        }
        bw.flush();
        bw.close();

    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        if (graph[x][y] == 'X' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        if (graph[x][y] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

}
