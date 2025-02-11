
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int N;
    static int M;
    static int K;
    static int[] startIdx = new int[2];
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        startIdx[0] = Integer.parseInt(st.nextToken());
        startIdx[1] = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] turn = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<K; i++) {
            turn[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<K; i++) {
            if (turn[i] == 1) {
                east();
            }
            else if (turn[i] == 2) {
                west();
            }
            else if (turn[i] == 3) {
                north();
            }
            else if (turn[i] == 4){
                south();
            }
        }
    }

    public static void east() {
        int tmpIdx = startIdx[1];
        if (tmpIdx+1 >=M) {
            return;
        }
        int tail = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = tail;
        startIdx[1]++;
        check();
    }

    public static void west() {
        int tmpIdx = startIdx[1];
        if (tmpIdx-1 < 0) {
            return;
        }
        int front = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = dice[5];
        dice[5] = front;
        startIdx[1] --;
        check();
    }

    public static void south() {
        int tmpIdx = startIdx[0];
        if (tmpIdx+1 >=N) {
            return;
        }
        int tail = dice[5];
        dice[5] = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[0];
        dice[0] = tail;
        startIdx[0]++;
        check();
    }

    public static void north() {
        int tmpIdx = startIdx[0];
        if (tmpIdx-1 < 0) {
            return;
        }
        int front = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[4];
        dice[4] = dice[5];
        dice[5] = front;
        startIdx[0]--;
        check();
    }

    private static void check() {
        int currentX = startIdx[0];
        int currentY = startIdx[1];

        int bottom = graph[currentX][currentY];
        if (bottom != 0) {
            dice[5] = bottom;
            graph[currentX][currentY] = 0;
        }

        if (bottom == 0) {
            graph[currentX][currentY] = dice[5];
        }
        System.out.println(dice[2]);
    }

}
