import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // dp 배열 초기화
        int[] dp = new int[n + 1];

        if (n >= 1) dp[1] = score[1];
        if (n >= 2) dp[2] = score[1] + score[2];
        if (n >= 3) {
            dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);
        }

        // 점화식을 이용하여 dp 배열 채우기
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-3]+score[i-1]+score[i], dp[i-2]+score[i]);
        }

        // 결과 출력
        System.out.println(dp[n]);
    }

}