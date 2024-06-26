import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++){
            int N = Integer.parseInt(br.readLine());

            if(N==0){
                System.out.println("1 0");
                continue;
            }
            int[] dp = new int[N+1];
            dp[0] = 0;
            dp[1] = 1;

            int[] countZero = new int[N+1];
            int[] countOne = new int[N+1];
            countZero[0] = 1;
            countOne[1] = 1;


            for(int i=2; i<=N; i++){
                dp[i] = dp[i-1]+dp[i-2];
                countZero[i] = countZero[i-1]+countZero[i-2];
                countOne[i] = countOne[i-1]+countOne[i-2];
            }

            System.out.println(countZero[N]+" "+countOne[N]);
        }
    }
}
