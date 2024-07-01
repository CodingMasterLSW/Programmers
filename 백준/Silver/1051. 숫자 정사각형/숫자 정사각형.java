import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] rec;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        rec = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                rec[i][j] = s.charAt(j) - '0';
            }
        }

        int maxArea = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxArea = Math.max(findSquare(i, j), maxArea);
            }
        }
        System.out.println(maxArea);


    }

    public static int findSquare(int i, int j) {
        int di = i+1;
        int dj = j+1;
        int maxArea = 0;

        while (di <= N - 1 && dj <= M - 1) {
            if (di == N - 1 || dj == M - 1) {
                if (rec[i][j] == rec[i][dj] && rec[i][j] == rec[di][j] && rec[i][j] == rec[di][dj]) {
                    int currentArea = (dj + 1 - j) * (di + 1 - i);
                    maxArea = Math.max(currentArea, maxArea);
                    return maxArea;
                } else{
                    break;
                }
            } else {

                if (rec[i][j] == rec[i][dj] && rec[i][j] == rec[di][j] &&
                        rec[i][j] == rec[di][dj]) {
                    int currentArea = (dj+1 - j) * (di+1-i);
                    if (maxArea < currentArea) {
                        maxArea = currentArea;
                    }
                }
                di++;
                dj++;

            }
        }

        return maxArea;
    }

}
