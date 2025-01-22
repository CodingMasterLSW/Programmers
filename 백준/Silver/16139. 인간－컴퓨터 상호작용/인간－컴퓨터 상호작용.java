
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String target = st.nextToken();

            int startValue = Integer.parseInt(st.nextToken());
            int endValue = Integer.parseInt(st.nextToken());
            int[] dp = new int[s.length()+1];

            dp[0] = 0;
            for (int j=1; j<=s.length(); j++) {
                if (target.equals(String.valueOf(s.charAt(j-1)))) {
                    dp[j] = dp[j-1] + 1;
                } else {
                    dp[j] = dp[j-1];
                }
            }

            System.out.println(dp[endValue+1] - dp[startValue]);
        }
    }
}
