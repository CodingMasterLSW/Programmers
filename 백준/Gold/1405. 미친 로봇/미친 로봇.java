import java.io.*;
import java.util.*;

class Main {

    static boolean[][] graph = new boolean[30][30];
    static boolean[][] visited = new boolean[30][30];

    static int[] current;
    static int[] arr = new int[4];
    static double sum = 0;
    static int c;
    
    static int[] cl = {1, -1, 0, 0};
    static int[] rl = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        current = new int[c];
        for (int i=0; i<4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited[15][15] = true;
        backtracking(0, 15, 15);     
        System.out.println(sum);  
    }

    public static void backtracking(int depth, int row, int col) {
        if (depth == c) {
            calculate();
            return;
        }

        for (int i=0; i<4; i++) {
            if (arr[i] == 0) {
                continue;
            }
            int nrow = row + rl[i];
            int ncol = col + cl[i];

            if (visited[nrow][ncol]) {
                continue;
            }

            visited[nrow][ncol] = true;
            current[depth] = i;
            backtracking(depth + 1, nrow, ncol);
            visited[nrow][ncol] = false;
        }
    }

    public static void calculate() {
        double currentSum = 1.0;

        for (int i=0; i<current.length; i++) {
            int c = current[i];
            int a = arr[c];
            currentSum *= a * 0.01;
        }
        sum += currentSum;
    }

    public static boolean canMove() {
        boolean[][] visited = new boolean[30][30];

        int row = 15;
        int column = 15;
        visited[row][column] = true;

        for (int i=0; i<current.length; i++) {
            int value = current[i];
            if (value == 0) {
                column ++;
            } else if (value == 1) {
                column--;
            } else if (value == 2) {
                row --;
            } else if (value == 3) {
                row ++;
            }
            
            if (visited[row][column]) {
                return false;
            }
            visited[row][column] = true;
        }
        return true;
    }
}