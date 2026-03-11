    import java.io.*;
    import java.util.*;

    class Main {
        public static void main(String[] args) throws IOException {
            long[][] dp = new long[31][31];

            for (int i=0; i<=30; i++) {
                dp[0][i] = 1;
            }

            for (int i=1; i<=30; i++) {
                for (int j=0; j<=30 - i; j++) {
                    // 반 남은 알약이 없는 경우
                    if (j == 0) {
                        dp[i][j] = dp[i-1][j+1];
                    } else {
                        dp[i][j] = dp[i][j-1] + dp[i-1][j+1];
                    }
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            while(true) {
                int N = Integer.parseInt(br.readLine());
                if (N == 0) {
                    break;
                }
                sb.append(dp[N][0]).append("\n");
            }
            System.out.println(sb.toString());
        }
    }