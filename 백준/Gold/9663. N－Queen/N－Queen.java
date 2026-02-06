import java.io.*;
import java.util.*;

class Main {

    static int N;
    static boolean[] visitedColumn;
    static boolean[] checkLeft;
    static boolean[] checkRight;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visitedColumn = new boolean[N];
        checkLeft = new boolean[2 * N-1];
        checkRight = new boolean[2 * N-1];

        backtracking(0);
        System.out.println(count);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i=0; i<N; i++) {
            if (visitedColumn[i]) {
                continue;
            }

            if (checkLeft[depth - i + (N - 1)]) {
                continue;
            }

            if (checkRight[depth + i]) {
                continue;
            }

            visitedColumn[i] = true;
            checkLeft[depth - i + (N - 1)] = true;
            checkRight[depth + i] = true;
            backtracking(depth + 1);
            visitedColumn[i] = false;
            checkLeft[depth - i + (N - 1)] = false;
            checkRight[depth + i] = false;
        }
    }
}