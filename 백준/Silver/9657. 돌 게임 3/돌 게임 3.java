import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        if(N>=1) dp[1] = 1;
        if(N>=2) dp[2] = 2;
        if(N>=3) dp[3] = 1;
        if(N>=4) dp[4] = 1;

        for(int i=5; i<=N; i++){
            if(dp[i-1]==2 || dp[i-3]==2 || dp[i-4] == 2){
                dp[i] = 1;
            } else{
                dp[i] = 2;
            }
        }
        if(dp[N]==1){
            System.out.println("SK");
        } else{
            System.out.println("CY");
        }
    }

}
