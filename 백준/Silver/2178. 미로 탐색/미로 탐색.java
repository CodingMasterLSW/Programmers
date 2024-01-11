import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};


    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (graph[nx][ny] == 0) { // 0이면 이동할 수 없음
                    continue;
                }
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return graph[n - 1][m - 1];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        graph = new int[n][m];

        for (int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = line.charAt(j)-'0';

            }
        }
        graph[0][0] = 1;

        int result = bfs(0, 0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }


}

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}