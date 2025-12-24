import java.io.*;
import java.util.*;

// 해야 하는 일
// 1) 세로 가능?
// 2) 가로 가능?
// 3) 3 * 3 가능?

class Main {

    static int N = 9;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0,0);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean backtracking(int row, int col) {
        if (col == 9) {
            return backtracking(row + 1, 0);
        }

        if (row == 9) {
            return true;
        }

        if (graph[row][col] != 0) {
            return backtracking(row, col + 1);
        }

        for (int i=1; i<=N; i++) {
            // 숫자 넣을 수 있음? 
            // isValid() -> 가로, 세로, 3*3에 해당 숫자 없음
            if (isValid(row, col, i)) {
                graph[row][col] = i;

                if (backtracking(row, col + 1)) {
                    return true;
                }
                graph[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isValid(int row, int col, int num) {
        // 가로 계산
        for (int i=0; i<N; i++) {
            if (graph[row][i] == num) {
                return false;
            } 
        }

        // 세로 계산
        for (int i=0; i<N; i++) {
            if (graph[i][col] == num) {
                return false;
            }
        }

        // 3*3 계산
        int nrow = (row / 3) * 3;
        int ncol = (col / 3) * 3;

        for (int i=nrow; i<nrow+3; i++) {
            for (int j=ncol; j<ncol+3; j++) {
                if (graph[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}