import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] dp = new int[m+1];

        int[] array = new int[m+1];


        for(int i=1; i<=m; i++){
            array[i] = sc.nextInt();
            dp[i] = dp[i-1]+array[i];
        }

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

     
            System.out.println(dp[y]-dp[x-1]);
        }

    }

}