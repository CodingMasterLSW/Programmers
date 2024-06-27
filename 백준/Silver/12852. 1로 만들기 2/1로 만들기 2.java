import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] trace = new int[N+1];

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1]+1;
            trace[i] = i-1;

            if (i%3 == 0 && dp[i]>dp[i/3]+1){
                dp[i] = dp[i/3]+1;
                trace[i] = i/3;
            }
            if(i%2 == 0 && dp[i]>dp[i/2]+1){
                dp[i] = dp[i/2]+1;
                trace[i] = i/2;
            }

        }
        System.out.println(dp[N]);

        StringBuilder sb = new StringBuilder();
        int current = N;
        while (current!=0){
            sb.append(current).append(" ");
            current = trace[current];
        }
        System.out.println(sb.toString().trim());
    }
}