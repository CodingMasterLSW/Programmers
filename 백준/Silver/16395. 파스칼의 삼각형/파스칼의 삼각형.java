import java.io.*;
import java.util.*;

class Main {

    static int[][] dp = new int[35][35];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n==0) {
            System.out.println(0);
            return;
        }

        if (m == 1) {
            System.out.println(1);
            return;
        }

        for (int i=0; i<=30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i=0; i<=30; i++) {
            for (int j=0; j<=30; j++) {
                dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}