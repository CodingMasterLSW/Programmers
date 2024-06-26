import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int[] dp = new int[k + 1];

        if (k >= 1) {
            dp[1] = 1;
        }
        if (k >= 2) {
            dp[2] = 2;
        }
        if (k >= 3) {
            dp[3] = 1;
        }

        for(int i=4; i<=k; i++){
            if(dp[i-3]==2){
                dp[i] = 1;
            }
            else if(dp[i-1]==2){
                dp[i] = 1;
            }
            else{
                dp[i] = 2;
            }
        }
        if(dp[k]==1){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }

}
