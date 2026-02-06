import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N][N];

        backtracking(0);

        System.out.println(count);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[depth][i] > 0) {
                continue;
            }

            move(depth, i);
            backtracking(depth +1);
            recovery(depth, i);
        }
    }

    public static void recovery(int row, int column) {
        // 좌,우
        for (int i=0; i<N; i++) {
            visited[row][i] --;
        }

        // 상,하
        for (int i=0; i<N; i++) {
            visited[i][column] --;
        }

        int cnt1 = 1;
        // 대각 이동 
        while(true) {
            if (row + cnt1 >= N || column + cnt1 >= N) {
                break;
            }
            visited[row + cnt1][column + cnt1] --;
            cnt1++;
        }

        int cnt2 = 1;
        while (true) {
            if (row - cnt2 < 0 || column - cnt2 < 0) {
                break;
            }
            visited[row - cnt2][column - cnt2] --;
            cnt2++;
        }

        int cnt3 = 1;
        while (true) {
            if (row - cnt3 < 0 || column + cnt3 >= N) {
                break;
            }
            visited[row - cnt3][column + cnt3] --;
            cnt3++;
        }

        int cnt4 = 1;
        while (true) {
            if (row + cnt4 >= N || column - cnt4 < 0) {
                break;
            }
            visited[row + cnt4][column - cnt4] --;
            cnt4++;
        }
    }

    public static void move(int row, int column) {
        // 좌,우
        for (int i=0; i<N; i++) {
            visited[row][i] ++;
        }

        // 상,하
        for (int i=0; i<N; i++) {
            visited[i][column] ++;
        }

        int cnt1 = 1;
        // 대각 이동 
        while(true) {
            if (row + cnt1 >= N || column + cnt1 >= N) {
                break;
            }
            visited[row + cnt1][column + cnt1] ++;
            cnt1++;
        }

        int cnt2 = 1;
        while (true) {
            if (row - cnt2 < 0 || column - cnt2 < 0) {
                break;
            }
            visited[row - cnt2][column - cnt2] ++;
            cnt2++;
        }

        int cnt3 = 1;
        while (true) {
            if (row - cnt3 < 0 || column + cnt3 >= N) {
                break;
            }
            visited[row - cnt3][column + cnt3] ++;
            cnt3++;
        }

        int cnt4 = 1;
        while (true) {
            if (row + cnt4 >= N || column - cnt4 < 0) {
                break;
            }
            visited[row + cnt4][column - cnt4] ++;
            cnt4++;
        }

    }
}