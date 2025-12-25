import java.io.*;
import java.util.*;

class Main {

    static int N = 9;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            String input = br.readLine();

            for (int j=0; j<input.length(); j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        backtracking(0, 0);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(graph[i][j]);
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
        // 가로 체크
        for (int i=0; i<N; i++) {
            if (graph[row][i] == num) {
                return false;
            } 
        }

        // 세로 체크
        for (int i=0; i<N; i++) {
            if (graph[i][col] == num){
                return false;
            }
        }

        int nRow = (row / 3) * 3;
        int nCol = (col / 3 ) * 3;

        for (int i=nRow; i<nRow+3; i++) {
            for (int j=nCol; j<nCol+3; j++) {
                if (graph[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    
}