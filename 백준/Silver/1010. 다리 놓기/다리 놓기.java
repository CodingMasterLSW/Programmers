import java.io.*;
import java.util.*;

class Main {

    static int[][] dp = new int[35][35];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<=30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i=0; i<=30; i++) {
            for (int j=0; j<=30; j++) {
                dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
            }
        }

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(dp[b][a]);
        }
    }
}