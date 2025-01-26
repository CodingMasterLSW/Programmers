import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;

    static int N;
    static int M;
    static int cnt = 1;

    static int direction;
    static int[] robot;
    static int[] dx = {-1,0,1,0}; //북 동 남 서
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        robot = new int[] {x, y};
        direction = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(robot[0], robot[1]);
        System.out.println(cnt);
    }

    public static void check(int x, int y) {

        graph[x][y] = -1;

        for (int i=0; i<4; i++) {
            direction = (direction + 3) % 4;

            int ndx = x + dx[direction];
            int ndy = y + dy[direction];

            if (ndx>=0 && ndx<N && ndy>=0 && ndy<M && graph[ndx][ndy] == 0) {
                cnt++;
                check(ndx, ndy);
                return;
            }
        }

        int d = (direction + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];
        if (bx<0 || bx>=N || by<0 || by>=M || graph[bx][by] == 1) {
            return;
        }

        check(bx, by);
    }
}
