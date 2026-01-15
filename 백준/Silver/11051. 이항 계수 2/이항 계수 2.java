import java.io.*;
import java.util.*;

class Main {

    static int[][] dp = new int[1005][1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기화 로직
        for (int i=0; i<=1000; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i=0; i<=1000; i++) {
            for (int j=0; j<=1000; j++) {
                dp[i+1][j+1] = (dp[i][j] + dp[i][j+1]) % 10007;
            }
        }
        System.out.println(dp[N][M]);

    }
}