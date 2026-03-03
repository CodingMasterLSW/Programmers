import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<3; j++) {
                dp[0][i][j] = arr[0][i]; 
            }
        }

        for (int i=1; i<N; i++) {
            for (int j=0; j<M; j++) {
                for (int z=0; z<3; z++) {

                    if (z==0) {
                        if (j == M-1) {
                            dp[i][j][0] = Integer.MAX_VALUE;
                            continue;
                        } 
                        dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
                    }
                    if (z==1) {
                        dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    }

                    if (z==2) {
                        if (j==0) {
                            dp[i][j][2] = Integer.MAX_VALUE;
                            continue;
                        }
                        dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + arr[i][j];
                    }
                }
            }
        }

        int minValue = Integer.MAX_VALUE;

        for (int j=0; j<M; j++) {
            for (int z=0; z<3; z++) {
                minValue = Math.min(dp[N-1][j][z], minValue);
            }
        }
        System.out.println(minValue);

    }
}