import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int[] arr;
    static int[] robots;
    static int N;
    static int M;
    static int goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N * 2];
        robots = new int[N];
        for (int i = 0; i < N * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                goal ++;
            }
        }

        while (goal < M) {
            cnt++;
            turn();
            move();
            putRobot();
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static void turn() {
        int last = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;

        for (int i = N - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }

        robots[0] = 0;
        if (robots[N - 1] == 1) {
            robots[N - 1] = 0;
        }
    }

    public static void move() {
        for (int i = N - 2; i > 0; i--) {
            if (robots[i] == 1 && robots[i + 1] != 1 && arr[i + 1] != 0) {
                arr[i + 1]--;
                if (arr[i + 1] == 0) {
                    goal++;
                }
                robots[i] = 0;
                robots[i + 1] = 1;
                if (robots[N - 1] == 1) {
                    robots[N - 1] = 0;
                }
            }
        }
    }

    public static void putRobot() {
        if (arr[0] != 0) {
            robots[0] = 1;
            arr[0] -= 1;
            if (arr[0] == 0) {
                goal++;
            }
        }
    }

    /*
    public static boolean check() {
        if (goal == M) {
            return true;
        }
        return false;
    }

     */
}
