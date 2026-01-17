import java.io.*;
import java.util.*;

class Main {

    static int[] dp = new int[13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i=5; i<=11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(dp[input]).append("\n");
        }
        System.out.println(sb.toString());
    }
}