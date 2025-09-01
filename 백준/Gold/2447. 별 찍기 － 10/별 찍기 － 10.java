import java.util.*;

public class Main {

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];
        recursion(0, 0, N, false);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void recursion(int row, int col, int n, boolean isBlank) {
        if (isBlank) {
            for (int i = row; i < row + n; i++) {
                for (int j = col; j < col + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            arr[row][col] = '*';
            return;
        }

        int count = 0;
        int newN = n / 3;

        for (int i = row; i < row + n; i += newN) {
            for (int j = col; j < col + n; j += newN) {
                count++;
                if (count == 5) {
                    recursion(i, j, newN, true);
                } else {
                    recursion(i, j, newN, false);
                }
            }
        }
    }

}
