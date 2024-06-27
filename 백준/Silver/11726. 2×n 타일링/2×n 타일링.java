

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int[] dp = new int[K+1];

        if(K>=1) dp[1] = 1;
        if(K>=2) dp[2] = 2;

        for(int i=3; i<=K; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }

        System.out.println(dp[K]);
    }

}
